package Ballshop.Project.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name="user" , schema="ballshop")
public class User {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private int id;

        @Column(name = "session_id")
        private String  sessionId;
        
        
        

  

    public int getId() {
        return id;
    }



	public String getSessionId() {
		return sessionId;
	}







	


	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	

   
}
