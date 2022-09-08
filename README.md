# hackaton-syndicate-project-template

### Installation

1. Install [AWS Syndicate](https://github.com/epam/aws-syndicate)
   deployment framework from `rc1.0.0` branch:
   `pip install git+https://github.com/epam/aws-syndicate@rc1.0.0`

2. Install [AWS Syndicate](https://github.com/epam/aws-syndicate)
   Maven plugin from `rc1.0.0` branch:
   `cd plugin`, `mvn clean install`

3. Configure `syndicate.yml` config file: replace `$ACCOUNT_ID`, `$ACCESS_KEY`,
   `$SECRET_KEY` and `$PATH_TO` with actual values

4. Configure `syndicate_aliases.yml` file: replace `$ACCOUNT_ID`(several times)
   and `$HASH`

### Deployment

1. Export path to the folder with `syndicate` configuration files:
   - Bash `export SDCT_CONF=$PATH_TO/.syndicate-config-dev`  
   - PowerShell `$env:SDCT_CONF='$PATH_TO\.syndicate-config-dev'`

2. Create S3 bucket for storing deployment artifacts (if not created yet):
   `syndicate create_deploy_target_bucket`

3. Build project
   `syndicate build --errors_allowed`

4. Deploy project
   `syndicate deploy`

### To remove deployed resources: 
`syndicate clean`

### In case of deployment errors:
1. Clean deployed resources:
   `syndicate clean --rollback`
   
3. Build
   `syndicate build --errors_allowed`

4. Deploy
   `syndicate deploy`