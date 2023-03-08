public class Referrer
{

    private String name;
    private String email;
    private String employer;
    private String uniqueLink;
    private List<Referree>  allReferrees;
    

    public Referrer(String name, String email, String employer){
        this.name = name;
        this email = email;
        this.employer = employer;
        this.allReferrees = new List<String>;
        uniqueLink = setUniqueLink(name, email);


    }

    public String setUniqueLink(String name, String email){
        String temp = name+email.length()+name.length();
        return temp;
    }

    public List<Referree> updateReferreeData(Referree referree){
        allReferrees.add(referree);
        return allReferrees;
    }

    public void getAllReferreeData(){
        for (Referee r: allReferrees){
            System.out.println(r.name, r.email, r.resume, r.note);
        }
    }

}
