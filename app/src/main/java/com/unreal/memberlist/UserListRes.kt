package com.unreal.memberlist

import com.google.gson.annotations.SerializedName

data class UserListRes(

	@field:SerializedName("UserListRes")
	val userListRes: List<UserListResItem?>? = null
)