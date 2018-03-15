# JDBCReview

This is a review of the knowledge of JDBC

Also with a summary of the JDBC

JDBC stands for Java Database Connectivity or Connector

This is the basic connection method for java database connection

Some frameworks did the further encapsulation of JDBC like MyBatis and Hibernate

Some disadvantages of JDBC:

1, Driver should be registered and released repeatly and frequently, waste of system resources

PreparedStatement pstmt = null;
Connection conn = JDBCConnection.getConnection();

finally{
    JDBCConnection.return(conn);
}

2, Plenty of work if Query changes (Maybe), hard to maintain
String sql = "select * from user where id = ?"; 
pstmt.setInt(1,userId);
->
String sql = "select * from user where username = ? and id = ?";
pstmt.setString(1,userName); 
pstmt.setInt(2, userId);

3, When getting a list of result, a traversal of the result set is necessary
ArrayList<User> userList = new ArrayList<User>();
while(resultSet.next()){
    User user = new User();
    user.set.........;
    userList.add(user);
}
