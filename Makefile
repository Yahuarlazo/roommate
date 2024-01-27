deploy-local: build
	docker compose down --remove-orphans -v
	docker compose up -d --build --force-recreate

build:
	# must spring.datasource.url be defined and mysql daemon running
	mvn -Dmaven.test.skip=true clean package
