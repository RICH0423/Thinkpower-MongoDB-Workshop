var dbName = 'grades'
var host = 'ds039484.mongolab.com:39484'
var user = 'rich'
var pass = '1234'

//Connection and auth
conn = new Mongo(host);
db = conn.getDB(dbName);
result = db.auth(user,pass);
print("-------------");


print("Current DB: " + db.getName());
print("");

print("All collection from DB: " + db.getCollectionNames());
print("");

print("User info: ");
printjson(db.getUser("rich"));
print("");

print("DB status: ");
var dbStatus = db.stats(1024); //KB
printjson(dbStatus);

storageSize = dbStatus.storageSize;

if (storageSize > 1000) {
	print("Storage Size :" + storageSize + " KB too large!");
} else {
	print("Storage Size: " + storageSize + " KB is OK!");
}
