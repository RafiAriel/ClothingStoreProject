package controller;
import View.*;
import model.*;
import model.entities.Member;

import java.sql.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;


public class MemberController implements Controller {
    ViewInterface viewInterface;
    model.MemberModel model;

    public MemberController(ViewInterface viewInterface, MemberModel model) {
        this.viewInterface = viewInterface;
        this.model = model;
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

    public void BirthdayPointAuto()
    {
        model.BirthdayPointAuto();
    }

    public void updateMembersPoints(int price, Member m)
    {
        model.updateMembersPoints(price, m);
    }

}
