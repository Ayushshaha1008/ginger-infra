environment = "prod"
aws_region = "us-east-1"

# RDS Variables
rds_instance_class        = "db.t3.medium"
rds_allocated_storage     = 100
rds_max_allocated_storage = 500
rds_username             = "admin"
rds_password             = "ProdPassword123"  # Change this in production

# EKS Variables
eks_project            = "cbz"
eks_desired_nodes      = 4
eks_max_nodes          = 8
eks_min_nodes          = 3
eks_node_instance_type = "t3.xlarge"

# S3 Variables
s3_bucket_name = "cbz-frontend-prod-bucket"
s3_environment = "prod" 


