source ../../common.sh

function main(){
  addPolicy pet-gateway cat-api
  addPolicy pet-gateway dog-api
  addPolicy pet-gateway adoption-api
  addPolicy pet-gateway pet-ui
  addPolicy adoption-api cat-api
  addPolicy adoption-api dog-api
}

main "$@"

