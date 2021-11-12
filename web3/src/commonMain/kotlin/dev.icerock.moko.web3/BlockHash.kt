/*
 * Copyright 2020 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

package dev.icerock.moko.web3

import dev.icerock.moko.web3.hex.Hex32String
import dev.icerock.moko.web3.hex.HexString
import dev.icerock.moko.web3.hex.ParametrizedHexStringSerializer
import kotlinx.serialization.Serializable

object BlockHashSerializer : ParametrizedHexStringSerializer<BlockHash>(BlockHash)

@Serializable(with = BlockHashSerializer::class)
class BlockHash(val value: String) : Hex32String by Hex32String(value) {
    override fun toString() = withoutPrefix 
    override fun hashCode(): Int = withoutPrefix.hashCode()
    override fun equals(other: Any?): Boolean = other is BlockHash && withoutPrefix == other.withoutPrefix

    companion object : HexString.Factory<BlockHash> {
        override fun createInstance(value: String): BlockHash = BlockHash(value)
    }
}
