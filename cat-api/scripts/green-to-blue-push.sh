source ../common.sh
cf push -f cf/manifest.yml --vars-file cf/variables/blue.yml -p build/libs/cat-api-0.0.1-SNAPSHOT.jar
#cf map-route cat-api-blue apps.pcfone.io --hostname cat-api-blue
addPolicy adoption-api cat-api-blue
addPolicy pet-gateway cat-api-blue
