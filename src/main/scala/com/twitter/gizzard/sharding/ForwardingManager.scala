package com.twitter.gizzard.sharding


trait ForwardingManager[S <: Shard] {
  def setForwarding(forwarding: Forwarding)

  def replaceForwarding(oldShardId: Int, newShardId: Int)

  def getForwarding(tableId: List[Int], baseId: Long): Int

  def getForwardingForShard(shardId: Int): Forwarding

  def getForwardings(): List[Forwarding]

  def findCurrentForwarding(tableId: List[Int], id: Long): S

  def reloadForwardings(nameServer: NameServer[S])

  // FIXME on these two:
  def copyShard(nameServer: NameServer[S], sourceShardId: Int, destinationShardId: Int)
  def migrateShard(nameServer: NameServer[S], migration: ShardMigration)
}
