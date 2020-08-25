package stanic.cmbot.service

class License(
    val license: String,
    val expire: Boolean,
    val expireTime: Long? = null
) {

    fun renoveTime() {}
    fun deleteLicense() {}
    fun createLicense(time: Long? = null) {}

}