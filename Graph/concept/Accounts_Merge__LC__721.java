package Graph.concept;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Mind_Coder
 */
/*
Given a list of accounts where each element accounts[i] is a list of strings, where the first element accounts[i][0] is a name, and the rest of the elements are emails representing emails of the account.

Now, we would like to merge these accounts. Two accounts definitely belong to the same person if there is some common email to both accounts. Note that even if two accounts have the same name, they may belong to different people as people could have the same name. A person can have any number of accounts initially, but all of their accounts definitely have the same name.

After merging the accounts, return the accounts in the following format: the first element of each account is the name, and the rest of the elements are emails in sorted order. The accounts themselves can be returned in any order.

 

Example 1:

Input: accounts = [["John","johnsmith@mail.com","john_newyork@mail.com"],["John","johnsmith@mail.com","john00@mail.com"],["Mary","mary@mail.com"],["John","johnnybravo@mail.com"]]
Output: [["John","john00@mail.com","john_newyork@mail.com","johnsmith@mail.com"],["Mary","mary@mail.com"],["John","johnnybravo@mail.com"]]
Explanation:
The first and second John's are the same person as they have the common email "johnsmith@mail.com".
The third John and Mary are different people as none of their email addresses are used by other accounts.
We could return these lists in any order, for example the answer [['Mary', 'mary@mail.com'], ['John', 'johnnybravo@mail.com'], 
['John', 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com']] would still be accepted.
Example 2:

Input: accounts = [["Gabe","Gabe0@m.co","Gabe3@m.co","Gabe1@m.co"],["Kevin","Kevin3@m.co","Kevin5@m.co","Kevin0@m.co"],["Ethan","Ethan5@m.co","Ethan4@m.co","Ethan0@m.co"],["Hanzo","Hanzo3@m.co","Hanzo1@m.co","Hanzo0@m.co"],["Fern","Fern5@m.co","Fern1@m.co","Fern0@m.co"]]
Output: [["Ethan","Ethan0@m.co","Ethan4@m.co","Ethan5@m.co"],["Gabe","Gabe0@m.co","Gabe1@m.co","Gabe3@m.co"],["Hanzo","Hanzo0@m.co","Hanzo1@m.co","Hanzo3@m.co"],["Kevin","Kevin0@m.co","Kevin3@m.co","Kevin5@m.co"],["Fern","Fern0@m.co","Fern1@m.co","Fern5@m.co"]]
 

Constraints:

1 <= accounts.length <= 1000
2 <= accounts[i].length <= 10
1 <= accounts[i][j] <= 30
accounts[i][0] consists of English letters.
accounts[i][j] (for j > 0) is a valid email.
*/

import java.util.*;
public class Accounts_Merge__LC__721 {
    
    public static void main(String arg[]){
        /*
            https://leetcode.com/problems/accounts-merge/
        */
    }
    static class Solution {
        static class Graph{
            static int V;
            static int[] parent;
            public Graph(int v){
                this.V = v;
                this.parent = new int[v];
                Arrays.fill(parent , -1);
            }

            public static int find(int u){
                if(parent[u]==-1)
                    return u;
                return find(parent[u]);
            }

            public static void union(int u, int v){
                int godFatherU = find(u);
                int godFatherV = find(v);
                if(godFatherU != godFatherV){
                    parent[godFatherU]=godFatherV;
                }

            }
        }

        public List<List<String>> accountsMerge(List<List<String>> accounts) {

            Graph g = new Graph(accounts.size());
            Map<String, Integer> emailImParent = new HashMap<>();
            for(int v=0; v<accounts.size();v++){
                List<String> currAcc = accounts.get(v);
                for(int i=1;i<currAcc.size();i++){
                    String currMail = currAcc.get(i);
                    if(!emailImParent.containsKey(currMail)){
                        emailImParent.put(currMail, v);
                    }
                    else{
                        g.union(v, emailImParent.get(currMail));
                    }
                }
            }
            // System.out.println(emailImParent);

            Map<Integer, List<String>> emailClubbed = new HashMap<>();
            for(String email: emailImParent.keySet()){
                int immParent = emailImParent.get(email);
                int godFather = g.find(immParent);

               List<String> emails = emailClubbed.getOrDefault(godFather, new ArrayList<>());
                emails.add(email);
                Collections.sort(emails);
                emailClubbed.put(godFather, emails);
            }
            // System.out.println(emailClubbed);

            List<List<String>> ans = new ArrayList<>();
            for(int v : emailClubbed.keySet()){
                String accountName = accounts.get(v).get(0);
                List<String> emails = emailClubbed.get(v);
                emails.add(0, accountName);
                            ans.add(emails);
            }
            return ans;
        }
    }
}
