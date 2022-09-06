package toy.aws;

import com.amazonaws.services.identitymanagement.AmazonIdentityManagement;
import com.amazonaws.services.identitymanagement.AmazonIdentityManagementClientBuilder;
import com.amazonaws.services.identitymanagement.model.CreateUserRequest;
import com.amazonaws.services.identitymanagement.model.CreateUserResult;
import com.amazonaws.services.identitymanagement.model.CreateAccessKeyRequest;
import com.amazonaws.services.identitymanagement.model.CreateAccessKeyResult;
import com.amazonaws.services.identitymanagement.model.AddUserToGroupRequest;
import com.amazonaws.services.identitymanagement.model.AddUserToGroupResult;

class AwsIAM {

    final AmazonIdentityManagement iam = AmazonIdentityManagementClientBuilder.defaultClient();
    String username;

    public void createUser(String username) {
        this.username = username;
        CreateUserRequest request = new CreateUserRequest(this.username);
        CreateUserResult response = iam.createUser(request);
        System.out.println( response ); // {User: {Path: /,UserName: Bob,UserId: xxxxxxxxxxx,Arn: arn:aws:iam::123456789012:user/Bob,CreateDate: Tue Sep 06 14:49:42 KST 2022,Tags: []}}
    }

    public CreateAccessKeyResult createAccessKey() {
        CreateAccessKeyRequest request = new CreateAccessKeyRequest(this.username);
        CreateAccessKeyResult response = iam.createAccessKey(request);
        return response;
    }
    
    public void addUserGroup(String groupname) {
        AddUserToGroupRequest request = new AddUserToGroupRequest(groupname, this.username);
        AddUserToGroupResult response = iam.addUserToGroup(request);
        System.out.println( response );
    }
}

public class App 
{
    public static void main( String[] args )
    {      
        String sample = "Bob";
        AwsIAM user = new AwsIAM();
        user.createUser(sample);
        user.addUserGroup("groupA");
        CreateAccessKeyResult credentials = user.createAccessKey();
        System.out.println(credentials); // {AccessKey: {UserName: Bob,AccessKeyId: xxxxxxxxxxxxx,Status: Active,SecretAccessKey: ***Sensitive Data Redacted***,CreateDate: Tue Sep 06 14:59:36 KST 2022}}
    }
}
