package com.epam.hackathon;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.syndicate.deployment.annotations.lambda.LambdaHandler;
import com.syndicate.deployment.annotations.environment.EnvironmentVariable;
import com.syndicate.deployment.annotations.environment.EnvironmentVariables;
import com.syndicate.deployment.annotations.events.SqsTriggerEventSource;

import java.util.HashMap;
import java.util.Map;

@LambdaHandler(lambdaName = "hackathon-lambda-function-TransformFilePartFunction",
	roleName = "hackathon-iam-role-DefaultLambdaRole",
	isPublishVersion = true,
	aliasName = "${lambdas_alias_name}",
	memory=256
)
@SqsTriggerEventSource(targetQueue = "hackathon-sqs-queue-table-TransformFilePartQueue", batchSize = 1)
@EnvironmentVariables(value = {
        @EnvironmentVariable(key = "SYSTEM_BUCKET", value = "${system-bucket-name}"),
        @EnvironmentVariable(key = "ORCHESTRATE_FILE_JOB_QUEUE", value = "${hackathon-sqs-queue-OrchestrateFileJobQueue-url}")
})
public class TransformFilePartFunction implements RequestHandler<Object, Map<String, Object>> {

	public Map<String, Object> handleRequest(Object request, Context context) {
		System.out.println("Hello from lambda");
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("statusCode", 200);
		resultMap.put("body", "Hello from Lambda");
		return resultMap;
	}
}
