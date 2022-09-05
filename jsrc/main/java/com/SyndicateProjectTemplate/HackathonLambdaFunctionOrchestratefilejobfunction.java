package com.SyndicateProjectTemplate;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.syndicate.deployment.annotations.lambda.LambdaHandler;
import com.syndicate.deployment.annotations.environment.EnvironmentVariable;
import com.syndicate.deployment.annotations.environment.EnvironmentVariables;
import com.syndicate.deployment.annotations.events.SqsTriggerEventSource;


import java.util.HashMap;
import java.util.Map;

@LambdaHandler(lambdaName = "hackathon-lambda-function-OrchestrateFileJobFunction",
	roleName = "hackathon-iam-role-DefaultLambdaRole",
	isPublishVersion = true,
	aliasName = "${lambdas_alias_name}",
	memory=256
)
@SqsTriggerEventSource(targetQueue = "hackathon-sqs-queue-OrchestrateFileJobQueue", batchSize = 1)
@EnvironmentVariables(value = {
        @EnvironmentVariable(key = "ORCHESTRATE_FILE_JOB_QUEUE", value = "${hackathon-sqs-queue-OrchestrateFileJobQueue-url}"),
        @EnvironmentVariable(key = "UNPACK_ARCHIVE_QUEUE", value = "${hackathon-sqs-queue-hackathon-sqs-queue-UnpackArchiveQueue-url}"),
        @EnvironmentVariable(key = "VALIDATE_FILEPART_QUEUE", value = "${hackathon-sqs-queue-table-ValidateFilePartQueue-url}"),
        @EnvironmentVariable(key = "TRANSFORM_FILEPART_QUEUE", value = "${hackathon-sqs-queue-table-TransformFilePartQueue-url}"),
        @EnvironmentVariable(key = "MERGE_FILEPART_QUEUE", value = "${hackathon-sqs-queue-table-MergeFilePartQueue-url}"),
        @EnvironmentVariable(key = "PACK_ARCHIVE_QUEUE", value = "${hackathon-sqs-queue-table-PackArchiveQueue-url}")
})
public class HackathonLambdaFunctionOrchestratefilejobfunction implements RequestHandler<Object, Map<String, Object>> {

	public Map<String, Object> handleRequest(Object request, Context context) {
		System.out.println("Hello from lambda");
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("statusCode", 200);
		resultMap.put("body", "Hello from Lambda");
		return resultMap;
	}
}
