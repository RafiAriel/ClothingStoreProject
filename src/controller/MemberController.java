package controller;
import view.*;
import model.*;
import model.entities.Member;


public class MemberController {
    ViewInterface viewInterface;
    model.MemberModel model;

    public MemberController(ViewInterface viewInterface, MemberModel model) {
        this.viewInterface = viewInterface;
        this.model = model;
    }

    public MemberController() {

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
