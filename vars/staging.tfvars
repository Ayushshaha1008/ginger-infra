environment = "staging"
aws_region = "us-east-1"

# RDS Variables
rds_instance_class        = "db.t3.small"
rds_allocated_storage     = 50
rds_max_allocated_storage = 200
rds_username             = "admin"
rds_password             = "StagingPassword123"  # Change this in production

# EKS Variables
eks_project            = "cbz"
eks_desired_nodes      = 3
eks_max_nodes          = 5
eks_min_nodes          = 2
eks_node_instance_type = "t3.large"

# S3 Variables
s3_bucket_name = "cbz-frontend-staging-bucket"
s3_environment = "staging" 