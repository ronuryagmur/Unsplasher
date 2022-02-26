package com.ronur.unsplasher.data

import android.os.Parcelable
import java.io.Serializable

data class Photo(
    val alt_description: String,
    val blur_hash: String,
    val categories: List<Any>,
    val color: String,
    val created_at: String,
    val current_user_collections: List<Any>,
    val description: Any,
    val height: Int,
    val id: String,
    val liked_by_user: Boolean,
    val likes: Int,
    val links: Links,
    val promoted_at: String,
    val sponsorship: Sponsorship,
    val topic_submissions: TopicSubmissions,
    val updated_at: String,
    val urls: Urls,
    val user: User,
    val width: Int
): Serializable

data class Links(
    val download: String,
    val download_location: String,
    val html: String,
    val self: String
)

data class Sponsorship(
    val impression_urls: List<String>,
    val sponsor: Sponsor,
    val tagline: String,
    val tagline_url: String
)

data class TopicSubmissions(
    val interiors: Interiors
)

data class Urls(
    val full: String,
    val raw: String,
    val regular: String,
    val small: String,
    val thumb: String
)

data class User(
    val accepted_tos: Boolean,
    val bio: String,
    val first_name: String,
    val for_hire: Boolean,
    val id: String,
    val instagram_username: String,
    val last_name: String,
    val links: LinksXX,
    val location: String,
    val name: String,
    val portfolio_url: String,
    val profile_image: ProfileImageX,
    val social: SocialX,
    val total_collections: Int,
    val total_likes: Int,
    val total_photos: Int,
    val twitter_username: Any,
    val updated_at: String,
    val username: String,
    val followers_count: Int?,
    val following_count: Int?
)

data class Sponsor(
    val accepted_tos: Boolean,
    val bio: String,
    val first_name: String,
    val for_hire: Boolean,
    val id: String,
    val instagram_username: String,
    val last_name: Any,
    val links: LinksX,
    val location: Any,
    val name: String,
    val portfolio_url: String,
    val profile_image: ProfileImage,
    val social: Social,
    val total_collections: Int,
    val total_likes: Int,
    val total_photos: Int,
    val twitter_username: String,
    val updated_at: String,
    val username: String
)

data class LinksX(
    val followers: String,
    val following: String,
    val html: String,
    val likes: String,
    val photos: String,
    val portfolio: String,
    val self: String
)

data class ProfileImage(
    val large: String,
    val medium: String,
    val small: String
)

data class Social(
    val instagram_username: String,
    val paypal_email: Any,
    val portfolio_url: String,
    val twitter_username: String
)

data class Interiors(
    val approved_on: String,
    val status: String
)

data class LinksXX(
    val followers: String,
    val following: String,
    val html: String,
    val likes: String,
    val photos: String,
    val portfolio: String,
    val self: String
)

data class ProfileImageX(
    val large: String,
    val medium: String,
    val small: String
)

data class SocialX(
    val instagram_username: String,
    val paypal_email: Any,
    val portfolio_url: String,
    val twitter_username: Any
)