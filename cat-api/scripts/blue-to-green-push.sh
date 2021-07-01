source ../common.sh
cf push -f cf/manifest.yml --vars-file cf/variables/green.yml -p build/libs/cat-api-0.0.1-SNAPSHOT.jar
cf map-route cat-api-green apps.pcfone.io --hostname cat-api-green
addPolicy adoption-api cat-api-green
addPolicy pet-gateway cat-api-green
