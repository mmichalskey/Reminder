import pymongo
from datetime import datetime
import socketio
import eventlet
from flask import Flask, render_template

# password TgltRS0maAKoiDGR

# username = "mmichalskey"
# password = "TgltRS0maAKoiDGR"
# login = "mongodb://%s:%s@calendar-shard-00-00-r7tf8.mongodb.net:27017,calendar-shard-00-01-r7tf8.mongodb.net:27017,calendar-shard-00-02-r7tf8.mongodb.net:27017/test?ssl=true&replicaSet=Calendar-shard-0&authSource=admin" % (username, password)

# client = pymongo.MongoClient(login)
# db = client.test_users

# user = {
#     "username" : "mmichalski234",
#     "password" : "test123",
#     "creation_time" : datetime.utcnow()
# }

# res = db.user.insert_one(user)
# print(res.inserted_id)
# print(db.users.find_one())