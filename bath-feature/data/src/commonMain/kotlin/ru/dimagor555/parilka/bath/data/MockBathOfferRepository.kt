package ru.dimagor555.parilka.bath.data

import ru.dimagor555.parilka.bath.domain.bathoffer.*
import ru.dimagor555.parilka.bath.domain.city.City
import ru.dimagor555.parilka.bath.domain.city.Country
import ru.dimagor555.parilka.bath.domain.city.GeoCoordinate
import ru.dimagor555.parilka.bath.domain.phone.PhoneNumber
import ru.dimagor555.parilka.bath.domain.phone.PhoneNumberFormat
import ru.dimagor555.parilka.bath.repository.BathOfferRepository

class MockBathOfferRepository : BathOfferRepository {
    private var bathOffersByIds: Map<Int, BathOffer>? = null

    override suspend fun getByCityId(cityId: Int): List<BathOffer> {
        val bathOffers = listOf(
            BathOffer(
                id = 0,
                type = BathOffer.Type.STANDARD,
                city = City1,
                rating = 3,
                content = Content1
            ),
            BathOffer(
                id = 1,
                type = BathOffer.Type.STANDARD,
                city = City2,
                rating = 4,
                content = Content2
            ),
            BathOffer(
                id = 2,
                type = BathOffer.Type.STANDARD,
                city = City3,
                rating = 5,
                content = Content3
            ),
            BathOffer(
                id = 3,
                type = BathOffer.Type.STANDARD,
                city = City1,
                rating = 3,
                content = Content3
            ),
            BathOffer(
                id = 4,
                type = BathOffer.Type.STANDARD,
                city = City2,
                rating = 4,
                content = Content1
            ),
            BathOffer(
                id = 5,
                type = BathOffer.Type.STANDARD,
                city = City3,
                rating = 5,
                content = Content2
            )
        )
        bathOffersByIds = bathOffers.associateBy { it.id }
        val offersByCityId = mutableListOf<BathOffer>()
        bathOffers.forEach {
            if (it.city.id == cityId) {
                offersByCityId.add(it)
            }
        }
        return offersByCityId
    }

    override suspend fun getById(id: Int): BathOffer? =
        bathOffersByIds?.get(id)
}

val City1 = City(
    id = 0,
    name =  "city 1",
    country = Country.UKRAINE,
    geoCoordinate = GeoCoordinate(23.4, 24.4)
)
val City2 = City(
    id = 1,
    name =  "city 2",
    country = Country.UKRAINE,
    geoCoordinate = GeoCoordinate(24.4, 25.4)
)
val City3 = City(
    id = 2,
    name =  "city 3",
    country = Country.RUSSIA,
    geoCoordinate = GeoCoordinate(22.4, 21.4)
)

val Location1 = Location(
    address = "address 1",
    subwayStation = "station 1",
    district = "district 1",
    googleMapUrl = "googleMapUrl 1"
)

val Location2 = Location(
    address = "address 2",
    subwayStation = "station 2",
    district = "district 2",
    googleMapUrl = "googleMapUrl 2"
)

val Location3 = Location(
    address = "address 3",
    subwayStation = "station 3",
    district = "district 3",
    googleMapUrl = "googleMapUrl 3"
)

val BathRentTerms1 = BathRentTerms(
    priceNames = setOf("100, 200"),
    promotions = setOf("promo 1, promo 2"),
    minPrice = 1000u,
    minRentHours = 2u
)

val BathRentTerms2 = BathRentTerms(
    priceNames = setOf("200, 300"),
    promotions = setOf("promo 2, promo 3"),
    minPrice = 2000u,
    minRentHours = 3u
)

val BathRentTerms3 = BathRentTerms(
    priceNames = setOf("300, 400"),
    promotions = setOf("promo 3, promo 4"),
    minPrice = 3000u,
    minRentHours = 4u
)

val Bath1 = Bath(
    bathTypes = setOf("type 1", "type 2", "type 3"),
    capacity = 10u,
    servicesByTypes = mapOf(
        Bath.ServiceType.BATH to setOf("BATH 1", "BATH 2", "BATH 3"),
        Bath.ServiceType.AQUA to setOf("AQUA 1", "AQUA 2", "AQUA 3"),
        Bath.ServiceType.ADDITIONAL to setOf("ADDITIONAL 1", "ADDITIONAL 2", "ADDITIONAL 3"),
        Bath.ServiceType.FOOD to setOf("FOOD 1", "FOOD 2", "FOOD 3")
    ),
    location = Location1
)

val Bath2 = Bath(
    bathTypes = setOf("type 2", "type 3", "type 4"),
    capacity = 12u,
    servicesByTypes = mapOf(
        Bath.ServiceType.BATH to setOf("BATH 2", "BATH 3", "BATH 4"),
        Bath.ServiceType.AQUA to setOf("AQUA 2", "AQUA 3", "AQUA 4"),
        Bath.ServiceType.ADDITIONAL to setOf("ADDITIONAL 2", "ADDITIONAL 3", "ADDITIONAL 4"),
        Bath.ServiceType.FOOD to setOf("FOOD 2", "FOOD 3", "FOOD 4")
    ),
    location = Location2
)

val Bath3 = Bath(
    bathTypes = setOf("type 3", "type 4", "type 5"),
    capacity = 8u,
    servicesByTypes = mapOf(
        Bath.ServiceType.BATH to setOf("BATH 3", "BATH 4", "BATH 5"),
        Bath.ServiceType.AQUA to setOf("AQUA 3", "AQUA 4", "AQUA 5"),
        Bath.ServiceType.ADDITIONAL to setOf("ADDITIONAL 3", "ADDITIONAL 4", "ADDITIONAL 5"),
        Bath.ServiceType.FOOD to setOf("FOOD 3", "FOOD 4", "FOOD 5")
    ),
    location = Location3
)

val PhoneNumber1 = PhoneNumber(
    format = PhoneNumberFormat.UKRAINE,
    number = "123456789"
)

val PhoneNumber2 = PhoneNumber(
    format = PhoneNumberFormat.UKRAINE,
    number = "234567891"
)

val PhoneNumber3 = PhoneNumber(
    format = PhoneNumberFormat.UKRAINE,
    number = "345678912"
)

val Content1 = BathOfferContent(
    name = "name 1",
    bath = Bath1,
    bathRentTerms = BathRentTerms1,
    description = "description 1",
    phoneNumber = PhoneNumber1,
    imageUrls = setOf("https://m-strana.ru/upload/iblock/c27/c27544cb25039c4c591d8e8d9a32a7f8.jpg", "img 2")
)

val Content2 = BathOfferContent(
    name = "name 2",
    bath = Bath2,
    bathRentTerms = BathRentTerms2,
    description = "description 2",
    phoneNumber = PhoneNumber2,
    imageUrls = setOf("https://modamix.net/wp-content/uploads/2018/12/slide3.jpg", "img 2")
)

val Content3 = BathOfferContent(
    name = "name 3",
    bath = Bath3,
    bathRentTerms = BathRentTerms3,
    description = "description 3",
    phoneNumber = PhoneNumber3,
    imageUrls = setOf("https://пробани-нн.рф/hspa3.jpg", "img 2")
)