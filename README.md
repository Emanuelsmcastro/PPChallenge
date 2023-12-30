# PPChallenge

docker run --name keycloak-test -p 9999:8080 -v .\keycloak_volume\keycloak:/opt/keycloak -e KEYCLOAK_ADMIN=admin -e KEYCLOAK_ADMIN_PASSWORD=admin quay.io/keycloak/keycloak:23.0.3 start-dev -> with bind amounts volume.

docker cp keycloak:/opt/keycloak/ .\keycloak_volume -> Copy volume to local folder.
