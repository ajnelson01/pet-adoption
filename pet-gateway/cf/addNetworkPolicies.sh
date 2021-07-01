function addPolicy(){
  cf add-network-policy $1 $2 -s development -o vmware-annelson --protocol tcp --port 8080
}

function main(){
  addPolicy pet-gateway cat-api
  addPolicy pet-gateway dog-api
  addPolicy pet-gateway adoption-api
  addPolicy pet-gateway pet-ui
  addPolicy adoption-api cat-api
  addPolicy adoption-api dog-api
}

main "$@"

