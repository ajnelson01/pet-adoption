pushd ./eureka
./gradlew bR &> /dev/null &
popd
pushd ./adoption-api
./gradlew bR &> /dev/null &
popd
pushd ./cat-api
./gradlew bR &> /dev/null &
popd
pushd ./dog-api
./gradlew bR &> /dev/null &
popd
pushd ./pet-gateway
./gradlew bR &> /dev/null &
popd
pushd ./pet-ui
yarn start &> /dev/null &
popd
