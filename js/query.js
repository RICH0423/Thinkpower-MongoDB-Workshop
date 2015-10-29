print("========= Query collection start!! ==========")
var dbName = 'grades'
var host = 'ds039484.mongolab.com:39484'
var user = 'rich'
var pass = '1234'

//Connection and auth
conn = new Mongo(host);
db = conn.getDB(dbName);
result = db.auth(user,pass);
print("Auth result: " + result)


gradeCount = db.grade.count();
print("grade total data count: " + result)

cursor = db.grade.find( {"student_id": 1} )
//cursor = db.grade.find( { $and: [ {"student_id": 1}, {"class_id" : 18} ] } )
//cursor = db.grade.find( {"student_id": 1, "class_id" : 18} )
while ( cursor.hasNext() ){
  	printjson(cursor.next());
}


print("========= Query collection finished!! ==========")