package erpsolwcp.erpsolwcpmodel.erpsolwcpqvo;

import erpsolglob.erpsolglobmodel.erpsolglobclasses.ERPSolGlobClassModel;

import erpsolwcp.erpsolwcpmodel.erpsolwcpqvo.common.VWWarrantyCardReportQVO;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Types;

import oracle.jbo.JboException;
import oracle.jbo.Row;
import oracle.jbo.server.ViewObjectImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Mon Jan 03 10:02:21 PKT 2022
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class VWWarrantyCardReportQVOImpl extends ViewObjectImpl implements VWWarrantyCardReportQVO {
    /**
     * This is the default constructor (do not remove).
     */
    public VWWarrantyCardReportQVOImpl() {
    }
    
    public void doERPSolUnsubmitWCP(){
            CallableStatement cs=this.getDBTransaction().createCallableStatement("begin ?:=PKG_WARRANTY_CARD.FUNC_SUBMIT_WARRANTY_CARD('"+this.first().getAttribute("Pckid")+"','"+this.first().getAttribute("txtDocTypeId")+"','"+ERPSolGlobClassModel.doGetUserCode()+"'); END;", 1);
            System.out.println("begin ?:=PKG_WARRANTY_CARD.FUNC_SUBMIT_WARRANTY_CARD('"+this.first().getAttribute("Pckid")+"','"+this.first().getAttribute("txtDocTypeId")+"','"+ERPSolGlobClassModel.doGetUserCode()+"'); END;");
            try {
                cs.registerOutParameter(1, Types.VARCHAR);
                cs.executeUpdate();
                throw new JboException(cs.getString(1));
                
            } catch (SQLException e) {
                System.out.println(e.getMessage()+ "this is message");
                throw new JboException("Unable to Unsupervise ");
            }
            finally{
                try {
                    cs.close();
                } catch (SQLException e) {
                }
            }
                
        
    }
}

