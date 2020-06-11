package controller;
import view.*;
import model.*;
import model.entities.Member;


public class MemberController {

    protected model.MemberModel model;


    public MemberController() {
        this.model = new MemberModel();
    }

    public void addClubMember(Member m)
    {
        model.addClubMember(m);
    }

    public void deleteClubMember(int id)
    {
        model.deleteClubMember(id);
    }

    public boolean isExistsClubMember(int id)
    {
        return model.isExistsClubMember(id);
    }

    public void birthdayPointAuto()
    {
        model.birthdayPointAuto();
    }

    public void updateMembersPoints(int price, Member m)
    {
        model.updateMembersPoints(price, m);
    }

}
