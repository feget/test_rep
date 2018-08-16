from pymongo import MongoClient


def bla():
	print ("Lopatko lychii")

client = MongoClient('localhost', 27017)

# Get the sampleDB database
db = client.admin
channel_name = "Wylsacom"
channel_id = "UCT8Rf6QQeFADwyyPTrGgT4Q"
f = 0
for i in db.allusers.find():
	channels = i["YouTube"]
	for x in channels:
		if x["title"] == channel_name:
			f+=1
if f > 0 :
	print ("dsfdsaf")
print (f)
user = db.youtube_channels.find_one({"channel_name" : "Wylsacom"})
print (user)
db.youtube_channels.delete_one({"channel_name" : "Wylsacom"})
#for i in  db.youtube_channels.find():
#	i.find_one({"channel_name" : "Wylsacom", "channel_id" : "UCFan5OZNealqfrHL_FLtL_w"})
#db.youtube_channels.update_one({"channel_name": channel_name }, {"$pull": {"channel_name" : channel_name, "channel_id" : channel_id }} )
