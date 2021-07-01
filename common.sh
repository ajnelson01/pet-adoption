function addPolicy(){
  cf add-network-policy $1 $2 -s development -o vmware-annelson --protocol tcp --port 8080
}
