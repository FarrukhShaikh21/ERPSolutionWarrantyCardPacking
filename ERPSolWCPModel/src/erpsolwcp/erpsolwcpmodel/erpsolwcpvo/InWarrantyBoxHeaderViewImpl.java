package erpsolwcp.erpsolwcpmodel.erpsolwcpvo;

import erpsolglob.erpsolglobmodel.erpsolglobclasses.ERPSolGlobClassModel;

import erpsolwcp.erpsolwcpmodel.erpsolwcpvo.common.InWarrantyBoxHeaderView;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Types;

import oracle.jbo.JboException;
import oracle.jbo.Row;
import oracle.jbo.server.ViewObjectImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Thu May 26 15:40:17 PKT 2022
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class InWarrantyBoxHeaderViewImpl extends ViewObjectImpl implements InWarrantyBoxHeaderView {
    /**
     * This is the default constructor (do not remove).
     */
    public InWarrantyBoxHeaderViewImpl() {
    }

    public void doSuperviseWarrantyBox() {
        
        CallableStatement cs=this.getDBTransaction().createCallableStatement("begin ?:=PKG_WARRANTY_CARD.FUNC_SUBMIT_WARRANTY_BOX('"+this.getCurrentRow().getAttribute("DocumentId")+"','"+ERPSolGlobClassModel.doGetUserCode()+"'); END;", 1);
        System.out.println("begin ?:=PKG_WARRANTY_CARD.FUNC_SUBMIT_WARRANTY_BOX('"+this.getCurrentRow().getAttribute("DocumentId")+"','"+ERPSolGlobClassModel.doGetUserCode()+"'); END;");
        try {
            cs.registerOutParameter(1, Types.VARCHAR);
            cs.executeUpdate();
            this.getCurrentRow().refresh(Row.REFRESH_WITH_DB_FORGET_CHANGES);
            
            if (!cs.getString(1).equals("ERPSOLSUCCESS")) {
    //               this.getCurrentRow().setAttribute("Submit", "N");
               this.getDBTransaction().commit();
                throw new JboException("Unable to supervise due to "+cs.getString(1));
               
           }
            this.getCurrentRow().setAttribute("Submit", "Y");
            this.getDBTransaction().commit();
        } catch (SQLException e) {
            this.getCurrentRow().setAttribute("Submit", "N");
            this.getDBTransaction().commit();
            System.out.println(e.getMessage()+ "this is message");
            throw new JboException("Unable to supervise ");
        }
        finally{
            try {
                cs.close();
            } catch (SQLException e) {
            }
        }
            
    }     
    
}

