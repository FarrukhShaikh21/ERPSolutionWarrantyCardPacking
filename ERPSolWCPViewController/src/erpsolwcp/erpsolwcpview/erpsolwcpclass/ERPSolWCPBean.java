package erpsolwcp.erpsolwcpview.erpsolwcpclass;

import erpsolglob.erpsolglobmodel.erpsolglobclasses.ERPSolGlobClassModel;

import erpsolglob.erpsolglobview.erpclass.ERPSolGlobalViewBean;

import java.sql.CallableStatement;

import java.sql.SQLException;
import java.sql.Types;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import oracle.adf.model.AttributeBinding;

import oracle.binding.BindingContainer;
import oracle.adf.model.BindingContext;
import oracle.adf.model.OperationBinding;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCDataControl;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.model.binding.DCIteratorBindingDef;
import oracle.adf.share.ADFContext;

import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.output.RichOutputText;
import oracle.adf.view.rich.context.AdfFacesContext;
import oracle.adf.view.rich.event.DialogEvent;

import oracle.adf.view.rich.render.ClientEvent;

import oracle.jbo.ApplicationModule;
import oracle.jbo.JboException;
import oracle.jbo.Row;
import oracle.jbo.ViewObject;
import oracle.jbo.domain.Date;
import oracle.jbo.server.DBTransaction;

import org.apache.myfaces.trinidad.render.ExtendedRenderKitService;
import org.apache.myfaces.trinidad.util.Service;

public class ERPSolWCPBean {
    public ERPSolWCPBean() {
        super();
    }

    String ERPSolStrUserCode;
    String ERPSolStrUserLocationCode;
    String ERPSolStrUserRegionCode;
    String ERPSolStrUserStoreCode;
    String ERPSolScanType="B";
    String ERPSolProductId;
    String ERPSolSalesOrderId;
    RichPopup ERPSolImeiPopup;
    String ERPSolImeiBox;
    RichInputText ERPSolImeiBoxText;
    RichInputText ERPSolRebateImeiBoxText;
    String ERPSolImeiString;
    String ERPSolReportName;
    RichInputText rip;
    RichOutputText ERPSolTotalImei;
    Integer ERPSolPerBox;
    BindingContainer ERPSolbc ;
    DCIteratorBinding ERPSolibImei;
    ViewObject ERPSolvoImei;
    DCIteratorBinding ERPSolibBox;
    ViewObject ERPSolvoBox;
    String ERPSolImeiStr;
    String ERPSolBoxStr;
    String ERPImeiSerial;
    ViewObject ERPSolSerialImei;
    ApplicationModule ERPSolAM;
        
    public void doSetERPSolWCPSessionGlobals() {
        System.out.println("glob user code"+getERPSolStrUserCode());
        System.out.println("glob user code"+getERPSolStrUserCode());
        if (getERPSolStrUserCode().length()==0) {
           FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Users Defaults are not defined properly. Please Check"));
           throw new JboException("Users Defaults are not defined properly. Please Check");
        }
        ADFContext.getCurrent().getPageFlowScope().put("GLOB_USER_CODE", getERPSolStrUserCode());
        ADFContext.getCurrent().getPageFlowScope().put("GLOB_USER_REGION", getERPSolStrUserRegionCode());
        ADFContext.getCurrent().getPageFlowScope().put("GLOB_USER_LOCATION", getERPSolStrUserLocationCode());
        ADFContext.getCurrent().getPageFlowScope().put("GLOB_USER_STORE", getERPSolStrUserStoreCode());
        ADFContext.getCurrent().getPageFlowScope().put("GLOB_COMPANY_CODE", "D");
    }


    public void setERPSolStrUserCode(String ERPSolStrUserCode) {
        this.ERPSolStrUserCode = ERPSolStrUserCode;
    }

    public String getERPSolStrUserCode() {
        return ERPSolStrUserCode;
    }

    public void setERPSolStrUserLocationCode(String ERPSolStrUserLocationCode) {
        this.ERPSolStrUserLocationCode = ERPSolStrUserLocationCode;
    }

    public String getERPSolStrUserLocationCode() {
        return ERPSolStrUserLocationCode;
    }

    public void setERPSolStrUserRegionCode(String ERPSolStrUserRegionCode) {
        this.ERPSolStrUserRegionCode = ERPSolStrUserRegionCode;
    }

    public String getERPSolStrUserRegionCode() {
        return ERPSolStrUserRegionCode;
    }

    public void setERPSolStrUserStoreCode(String ERPSolStrUserStoreCode) {
        this.ERPSolStrUserStoreCode = ERPSolStrUserStoreCode;
    }

    public String getERPSolStrUserStoreCode() {
        return ERPSolStrUserStoreCode;
    }
//VWDocumentForUnsubmitAutoSuggestRO
        public List<SelectItem> doERPSolGetAutoSuggestedStoreValues(String pStringValues) {
//public static List<SelectItem> doERPSolGetAutoSuggestedValues(String pSearch,String pViewObjectName,String pWhereColumn,String pAttribute1,String pAttribute2,Integer pNoOfRecordsSuggest) {
        //public List<SelectItem> doERPSolGetAutoSuggestedValues(String pSearch,String pViewObjectName,String pWhereColumn,String pAttribute1,String pAttribute2,Integer pNoOfRecordsSuggest) {
        List<SelectItem> ResultList=new ArrayList<SelectItem>();
        System.out.println("a");
        BindingContainer ERPSolbc=ERPSolGlobalViewBean.doGetERPBindings();
        System.out.println("b");
        AttributeBinding ERPLocid =(AttributeBinding)ERPSolbc.getControlBinding("Locationid");
        System.out.println("c");
//        String ERPLocid=""+ERPSolib.getCurrentRow().getAttribute("Locationid");
        System.out.println("d");
        System.out.println(ERPLocid.getInputValue());//ERPSolGlobalViewBean.
        ResultList= ERPSolGlobalViewBean.doERPSolGetAutoSuggestedValues(pStringValues, "AllStoresAutoSuggestRO",
                                                            "LOCATIONID='"+ERPLocid.getInputValue()+"' AND UPPER(CONCAT(STOREID,STORE_NAME))", "StoreName", "Storeid", 10);
        return ResultList;
        
    }
        
    public List<SelectItem> doERPSolGetAutoSuggestedUnsubmitWCP(String pStringValues) {
//public static List<SelectItem> doERPSolGetAutoSuggestedValues(String pSearch,String pViewObjectName,String pWhereColumn,String pAttribute1,String pAttribute2,Integer pNoOfRecordsSuggest) {
        //public List<SelectItem> doERPSolGetAutoSuggestedValues(String pSearch,String pViewObjectName,String pWhereColumn,String pAttribute1,String pAttribute2,Integer pNoOfRecordsSuggest) {
        List<SelectItem> ResultList=new ArrayList<SelectItem>();
        System.out.println("a");
        BindingContainer ERPSolbc=ERPSolGlobalViewBean.doGetERPBindings();
        DCIteratorBinding ERPSolIB=(DCIteratorBinding)ERPSolbc.get("VWWarrantyCardReportROIterator");
        ApplicationModule ERPSolAM=ERPSolIB.getViewObject().getApplicationModule();
        System.out.println("b");
        String ERPLocid=ERPSolGlobClassModel.doGetUserLocationCode();
        AttributeBinding ERPDocType =(AttributeBinding)ERPSolbc.getControlBinding("txtDocTypeId");
        ViewObject vo=ERPSolAM.findViewObject("VWDocumentForUnsubmitAutoSuggestRO");
        vo.setNamedWhereClauseParam("P_ADF_DOCTYPEID", ERPDocType.getInputValue());
        vo.setNamedWhereClauseParam("P_ADF_LOCATIONID", ERPLocid);
        vo.executeQuery();
        
        
        System.out.println("c");
//        String ERPLocid=""+ERPSolib.getCurrentRow().getAttribute("Locationid");
        System.out.println("d");
        System.out.println(ERPLocid);//ERPSolGlobalViewBean.
        ResultList= ERPSolGlobalViewBean.doERPSolGetAutoSuggestedValues(pStringValues, "VWDocumentForUnsubmitAutoSuggestRO",
                                                            " UPPER(CONCAT(Doc_Id,Description))", "DocId", "Description", 10);
        return ResultList;
        
    }
    
    public List<SelectItem> doERPSolGetAutoSuggestedCustomerValues(String pStringValues) {
    //public static List<SelectItem> doERPSolGetAutoSuggestedValues(String pSearch,String pViewObjectName,String pWhereColumn,String pAttribute1,String pAttribute2,Integer pNoOfRecordsSuggest) {
        //public List<SelectItem> doERPSolGetAutoSuggestedValues(String pSearch,String pViewObjectName,String pWhereColumn,String pAttribute1,String pAttribute2,Integer pNoOfRecordsSuggest) {
        List<SelectItem> ResultList=new ArrayList<SelectItem>();
        System.out.println("a");
        BindingContainer ERPSolbc=ERPSolGlobalViewBean.doGetERPBindings();
        System.out.println("b");
        AttributeBinding ERPLocid =(AttributeBinding)ERPSolbc.getControlBinding("Locationid");
        System.out.println("c");
        
        System.out.println("d");
        System.out.println(ERPLocid);//ERPSolGlobalViewBean.
        ResultList= ERPSolGlobalViewBean.doERPSolGetAutoSuggestedValues(pStringValues, "AllCustomersAutoSuggestRO",
                                                            "LOCATIONID='"+ERPLocid.getInputValue()+"' AND UPPER(CONCAT(CUSTOMERID,CUSTOMER_NAME))", "CustomerName", "Customerid", 10);
        return ResultList;
        
    }   

    public List<SelectItem> doERPSolGetAutoSuggestedSalesPersonValues(String pStringValues) {
    //public static List<SelectItem> doERPSolGetAutoSuggestedValues(String pSearch,String pViewObjectName,String pWhereColumn,String pAttribute1,String pAttribute2,Integer pNoOfRecordsSuggest) {
        //public List<SelectItem> doERPSolGetAutoSuggestedValues(String pSearch,String pViewObjectName,String pWhereColumn,String pAttribute1,String pAttribute2,Integer pNoOfRecordsSuggest) {
        List<SelectItem> ResultList=new ArrayList<SelectItem>();
        System.out.println("a");
        BindingContainer ERPSolbc=ERPSolGlobalViewBean.doGetERPBindings();
        System.out.println("b");
        AttributeBinding ERPCustomerId =(AttributeBinding)ERPSolbc.getControlBinding("Customerid");
        System.out.println("c");
//        String ERPCustomerId=""+ERPSolib.getCurrentRow().getAttribute("Customerid");
        System.out.println("d");
        System.out.println(ERPCustomerId);//ERPSolGlobalViewBean.
        ResultList= ERPSolGlobalViewBean.doERPSolGetAutoSuggestedValues(pStringValues, "SoSalesPersonsAutoSuggestRO",
                                                            "SALESPERSONID IN (SELECT ASP.SALESPERSONID from ALL_CUSTOMER_SALESPERSON ASP WHERE ASP.CUSTOMERID='"+ERPCustomerId.getInputValue()+"') AND UPPER(CONCAT(Salespersonid,name))", "Name", "Salespersonid", 10);
        return ResultList;
        
    }   
   
    public List<SelectItem> doERPSolGetAutoSuggestedSupplierValues(String pStringValues) {
    //public static List<SelectItem> doERPSolGetAutoSuggestedValues(String pSearch,String pViewObjectName,String pWhereColumn,String pAttribute1,String pAttribute2,Integer pNoOfRecordsSuggest) {
        //public List<SelectItem> doERPSolGetAutoSuggestedValues(String pSearch,String pViewObjectName,String pWhereColumn,String pAttribute1,String pAttribute2,Integer pNoOfRecordsSuggest) {
        List<SelectItem> ResultList=new ArrayList<SelectItem>();
        System.out.println("a");
        BindingContainer ERPSolbc=ERPSolGlobalViewBean.doGetERPBindings();
        System.out.println("b");
//        Attribute ERPSolib =(Attribute)ERPSolbc.get("SoSalesOrderViewCRUDIterator");
        System.out.println("c");
        AttributeBinding ERPLocid =(AttributeBinding)ERPSolbc.getControlBinding("Locationid");
        System.out.println("d");
        System.out.println(ERPLocid.getInputValue());//ERPSolGlobalViewBean.
        ResultList= ERPSolGlobalViewBean.doERPSolGetAutoSuggestedValues(pStringValues, "PuSuppliersAutoSuggestRO",
                                                            "LOCATIONID='"+ERPLocid.getInputValue()+"' AND UPPER(CONCAT(SUPPLIERID,SUPP_NAME))", "SuppName", "Supplierid", 10);
        return ResultList;
        
    }   
     
    
    public List<SelectItem> doERPSolGetAutoSuggestedModelValues(String pStringValues) {
    //public static List<SelectItem> doERPSolGetAutoSuggestedValues(String pSearch,String pViewObjectName,String pWhereColumn,String pAttribute1,String pAttribute2,Integer pNoOfRecordsSuggest) {
        //public List<SelectItem> doERPSolGetAutoSuggestedValues(String pSearch,String pViewObjectName,String pWhereColumn,String pAttribute1,String pAttribute2,Integer pNoOfRecordsSuggest) {
        List<SelectItem> ResultList=new ArrayList<SelectItem>();
        ResultList= ERPSolGlobalViewBean.doERPSolGetAutoSuggestedValues(pStringValues, "InItemsAutoSuggestRO"," UPPER(CONCAT(Productid,Description))", "Description", "Productid", 10);
        return ResultList;
        
    }   
    public void doERPSolWarrantyCard(DialogEvent erpsolde) {
        if (erpsolde.getOutcome()==DialogEvent.Outcome.yes) {
            OperationBinding binding = ERPSolGlobalViewBean.doIsERPSolGerOperationBinding("Commit");
            binding.execute();
            binding = ERPSolGlobalViewBean.doIsERPSolGerOperationBinding("doSuperviseWarrantyCard");
            binding.execute();
        }
    }

    public void doERPSoRebatelDialogConfirm(DialogEvent erpsolde) {
        if (erpsolde.getOutcome()==DialogEvent.Outcome.yes) {
            OperationBinding binding = ERPSolGlobalViewBean.doIsERPSolGerOperationBinding("doSuperviseSalesRebate");
            binding.execute();
        }
    }

    public void setERPSolImeiPopup(RichPopup ERPSolImeiPopup) {
        this.ERPSolImeiPopup = ERPSolImeiPopup;
    }

    public RichPopup getERPSolImeiPopup() {
        return ERPSolImeiPopup;
    }

    public String DoShowERPSolImeiPopup() {
        RichPopup.PopupHints ERPSolHints=new RichPopup.PopupHints();
        getERPSolImeiPopup().show(ERPSolHints);
        return null;
    }
    public void erpSolSoImeiBox(ValueChangeEvent erpvce) {
        if (erpvce.getNewValue()==null) {
            return ;
        }
        System.out.println("1so");
        DCBindingContainer bc = (DCBindingContainer) ERPSolGlobalViewBean.doGetERPBindings();
        System.out.println("2so");
        DCDataControl dc = bc.getDataControl();
        System.out.println("3");
        String ERPSolPlsql="begin ?:=PKG_SALE_ORDER.FUNC_IMEI_BOX_VALIDATION('"+getERPSolSalesOrderId()+"','"+erpvce.getNewValue()+"','"+getERPSolScanType()+"','"+getERPSolProductId()+"'); end;";
        System.out.println("4");
        DBTransaction erpsoldbt=(DBTransaction)dc.getApplicationModule().getTransaction();
        System.out.println("5");
        CallableStatement cs = erpsoldbt.createCallableStatement(ERPSolPlsql, DBTransaction.DEFAULT);
        try {
                     System.out.println("6");
                     cs.registerOutParameter(1, Types.VARCHAR);
                     System.out.println("7");
                     cs.executeUpdate();
                     System.out.println("8");
                     ERPSolPlsql=cs.getString(1);
                     System.out.println("9");
                     if (ERPSolPlsql.equals("ERPSOLSUCCESS"))
                     {  
                         
                         erpsoldbt.commit();
                     dc.getApplicationModule().findViewObject("SoSalesOrderImeiDetCRUD").executeQuery();
                         dc.getApplicationModule().findViewObject("SoSalesOrderViewCRUD").getCurrentRow().setAttribute("txtIMEIAndBox", null);
                     }
                     else {
                         FacesContext.getCurrentInstance().addMessage(null , new FacesMessage(ERPSolPlsql));
                //                throw new JboException(ERPSolPlsql);
                     }
                 } catch (SQLException e) {
                     
                 }
                 finally{
                    try {
                        cs.close();
                    } catch (SQLException e) {
                    }
                }
    System.out.println("hello");
        setERPSolImeiBox(null);
        getERPSolImeiBoxText().setValue(null);
        AdfFacesContext.getCurrentInstance().addPartialTarget(getERPSolImeiBoxText());
        System.out.println("5435");    
        
    }

    public void doERPSolScanRebateImei2(ValueChangeEvent erpvcevt) {
        System.out.println(erpvcevt.getNewValue()+ " get new value");
        System.out.println("one");
    }

    public void doERPSolScanRebateImei(ValueChangeEvent erpvce) {
        System.out.println(erpvce.getNewValue()+ " get new value");
        System.out.println("1");
        DCBindingContainer bc = (DCBindingContainer) ERPSolGlobalViewBean.doGetERPBindings();
        System.out.println("2");
        DCDataControl dc = bc.getDataControl();
        System.out.println("3");
        String ERPSolPlsql="begin ?:=PKG_SALES_REBATE.FUNC_IMEI_VALIDATION('"+getERPSolSalesOrderId()+"','"+erpvce.getNewValue()+"','"+ERPSolGlobClassModel.doGetUserCode()+"'); end;";
        System.out.println("4");
        DBTransaction erpsoldbt=(DBTransaction)dc.getApplicationModule().getTransaction();
        System.out.println("5");
        CallableStatement cs = erpsoldbt.createCallableStatement(ERPSolPlsql, DBTransaction.DEFAULT);
        try {
                     System.out.println("6");
                     cs.registerOutParameter(1, Types.VARCHAR);
                     System.out.println("7");
                     cs.executeUpdate();
                     System.out.println("8");
                     ERPSolPlsql=cs.getString(1);
                     System.out.println("9");
                     if (ERPSolPlsql.equals("ERPSOLSUCCESS"))
                     {  
                         
                         erpsoldbt.commit();
                     }
                     else {
                         FacesContext.getCurrentInstance().addMessage(null , new FacesMessage(ERPSolPlsql));
                     }
                 } catch (SQLException e) {
                     
                 }
                 finally{
                    try {
                        cs.close();
                    } catch (SQLException e) {
                    }
                }
        
        dc.getApplicationModule().findViewObject("SoRebateImeDetCRUD").executeQuery();
    }


    public void setERPSolScanType(String ERPSolScanType) {
        this.ERPSolScanType = ERPSolScanType;
    }

    public String getERPSolScanType() {
        return ERPSolScanType;
    }

    public void setERPSolProductId(String ERPSolProductId) {
        this.ERPSolProductId = ERPSolProductId;
    }

    public String getERPSolProductId() {
        return ERPSolProductId;
    }

    public void setERPSolSalesOrderId(String ERPSolSalesOrderId) {
        this.ERPSolSalesOrderId = ERPSolSalesOrderId;
    }

    public String getERPSolSalesOrderId() {
        return ERPSolSalesOrderId;
    }

    public void setERPSolImeiBox(String ERPSolImeiBox) {
        this.ERPSolImeiBox = ERPSolImeiBox;
    }

    public String getERPSolImeiBox() {
        return ERPSolImeiBox;
    }

    public void setERPSolImeiBoxText(RichInputText ERPSolImeiBoxText) {
        this.ERPSolImeiBoxText = ERPSolImeiBoxText;
    }

    public RichInputText getERPSolImeiBoxText() {
        return ERPSolImeiBoxText;
    }

    public void setERPSolRebateImeiBoxText(RichInputText ERPSolRebateImeiBoxText) {
        this.ERPSolRebateImeiBoxText = ERPSolRebateImeiBoxText;
    }

    public RichInputText getERPSolRebateImeiBoxText() {
        return ERPSolRebateImeiBoxText;
    }

    public void setERPSolImeiString(String ERPSolImeiString) {
        this.ERPSolImeiString = ERPSolImeiString;
    }

    public String getERPSolImeiString() {
        return ERPSolImeiString;
    }
    public String doGenerateSoRebateDetail() {
     
        System.out.println("1");
        DCBindingContainer bc = (DCBindingContainer) ERPSolGlobalViewBean.doGetERPBindings();
        System.out.println("2");
        DCDataControl dc = bc.getDataControl();
        System.out.println("3");
        String ERPSolPlsql="begin ?:=PKG_SALES_REBATE.FUNC_MAKE_PRODUCT_FROM_IMEI('"+getERPSolSalesOrderId()+"','"+ERPSolGlobClassModel.doGetUserCode()+"'); end;";
        System.out.println("4");
        DBTransaction erpsoldbt=(DBTransaction)dc.getApplicationModule().getTransaction();
        System.out.println("5");
        CallableStatement cs = erpsoldbt.createCallableStatement(ERPSolPlsql, DBTransaction.DEFAULT);
        try {
                     System.out.println("6");
                     cs.registerOutParameter(1, Types.VARCHAR);
                     System.out.println("7");
                     cs.executeUpdate();
                     System.out.println("8");
                     ERPSolPlsql=cs.getString(1);
                     System.out.println("9");
                     if (ERPSolPlsql.equals("ERPSOLSUCCESS"))
                     {  
                         
                         erpsoldbt.commit();
                     }
                     else {
                         FacesContext.getCurrentInstance().addMessage(null , new FacesMessage(ERPSolPlsql));
                     }
                 } catch (SQLException e) {
                     
                 }
                 finally{
                    try {
                        cs.close();
                    } catch (SQLException e) {
                    }
                }
        
        
           
        return "ACT-BACK-FROM-REBATE-IMEI";
    }
    
    public void doERPSolFocusNextField(ClientEvent ce) {
        System.out.println("hello");
        UIComponent rcb = ce.getComponent();
           System.out.println("hello-1");
        String focusOn = (String)rcb.getAttributes().get("erpNextUIC");
           System.out.println("hello-3>>"+ focusOn);
        String script="comp = AdfPage.PAGE.findComponentByAbsoluteId('"+focusOn+"');" + " comp.focus();";
        writeJavaScriptToClient(script);
       }


    public String doERPSolExecuteWCPReport() {
        BindingContainer bc = ERPSolGlobalViewBean.doGetERPBindings();
        DCIteratorBinding ib=(DCIteratorBinding)bc.get("InSetPackingCRUDIterator");
        ApplicationModule am=ib.getViewObject().getApplicationModule();
        ViewObject vo=am.findViewObject("QVOWCP");
        if (vo!=null) {
            vo.remove();
       }
        
        vo=am.createViewObjectFromQueryStmt("QVOWCP", "select PARAMETER_VALUE FROM so_sales_parameter a where a.Parameter_Id='REPORT_SERVER_URL'");
        vo.executeQuery();
        String pReportUrl=vo.first().getAttribute(0).toString();
        vo.remove();
        vo=am.createViewObjectFromQueryStmt("QVOWCP", "select PATH PATH FROM SYSTEM a where a.PROJECTID='WTY' ");
        vo.executeQuery();
        String pReportPath=vo.first().getAttribute(0).toString()+"REPORTS\\\\";
        System.out.println(pReportPath);
        pReportPath=pReportPath+"RPT_PACKING";
        
    
        BindingContainer ERPSolbc=ERPSolGlobalViewBean.doGetERPBindings();
        System.out.println("b");
//        AttributeBinding ERPCompanyid       =(AttributeBinding)ERPSolbc.getControlBinding("Companyid");
        AttributeBinding ERPPackingid        =(AttributeBinding)ERPSolbc.getControlBinding("Pckid");
        String reportParameter="";
//        reportParameter="COMPANY="+ (ERPCompanyid.getInputValue()==null?"":ERPCompanyid.getInputValue());
        reportParameter+="&VPCKID="+ERPPackingid.getInputValue();
    //        reportParameter+="&P_STOREID_ID="+(ERPStoreid.getInputValue()==null?"":ERPStoreid.getInputValue());
        reportParameter+="&USER="+ERPSolGlobClassModel.doGetUserCode();
        
        pReportUrl=pReportUrl.replace("<P_REPORT_PATH>", pReportPath);
        pReportUrl=pReportUrl.replace("<P_REPORT_PARAMETERS>", reportParameter);
        
        System.out.println(pReportPath);
        System.out.println(reportParameter);
        System.out.println(pReportUrl);
        
        doErpSolOpenReportTab(pReportUrl);
        return null;
    }
    public String doERPSolExecuteWCRefreshReport() {
        BindingContainer bc = ERPSolGlobalViewBean.doGetERPBindings();
        DCIteratorBinding ib=(DCIteratorBinding)bc.get("InSetPackingRepackCRUDIterator");
        ApplicationModule am=ib.getViewObject().getApplicationModule();
        ViewObject vo=am.findViewObject("QVOWCPRP");
        if (vo!=null) {
            vo.remove();
       }
        
        vo=am.createViewObjectFromQueryStmt("QVOWCPRP", "select PARAMETER_VALUE FROM so_sales_parameter a where a.Parameter_Id='REPORT_SERVER_URL'");
        vo.executeQuery();
        String pReportUrl=vo.first().getAttribute(0).toString();
        vo.remove();
        vo=am.createViewObjectFromQueryStmt("QVOWCPRP", "select PATH PATH FROM SYSTEM a where a.PROJECTID='WTY' ");
        vo.executeQuery();
        String pReportPath=vo.first().getAttribute(0).toString()+"REPORTS\\\\";
        System.out.println(pReportPath);
        pReportPath=pReportPath+"RPT_PACKING";
        
    
        BindingContainer ERPSolbc=ERPSolGlobalViewBean.doGetERPBindings();
        System.out.println("b");
    //        AttributeBinding ERPCompanyid       =(AttributeBinding)ERPSolbc.getControlBinding("Companyid");
        AttributeBinding ERPPackingid        =(AttributeBinding)ERPSolbc.getControlBinding("Pckid");
        String reportParameter="";
    //        reportParameter="COMPANY="+ (ERPCompanyid.getInputValue()==null?"":ERPCompanyid.getInputValue());
        reportParameter+="&VPCKID="+ERPPackingid.getInputValue();
    //        reportParameter+="&P_STOREID_ID="+(ERPStoreid.getInputValue()==null?"":ERPStoreid.getInputValue());
        reportParameter+="&USER="+ERPSolGlobClassModel.doGetUserCode();
        
        pReportUrl=pReportUrl.replace("<P_REPORT_PATH>", pReportPath);
        pReportUrl=pReportUrl.replace("<P_REPORT_PARAMETERS>", reportParameter);
        
        System.out.println(pReportPath);
        System.out.println(reportParameter);
        System.out.println(pReportUrl);
        
        doErpSolOpenReportTab(pReportUrl);
        return null;
    }
    private void writeJavaScriptToClient(String script) {
            FacesContext fctx = FacesContext.getCurrentInstance();
            ExtendedRenderKitService erks = null;
            erks = Service.getRenderKitService(fctx, ExtendedRenderKitService.class);
            erks.addScript(fctx, script);
        }

    public void doErpSolOpenReportTab(String url) {
    ExtendedRenderKitService erks =
    Service.getRenderKitService(FacesContext.getCurrentInstance(), ExtendedRenderKitService.class);
    StringBuilder strb = new StringBuilder("window.open('" + url + "');");
    erks.addScript(FacesContext.getCurrentInstance(), strb.toString());
    }        
    public void ERPSolIMEIVce(ValueChangeEvent vce) {
        System.out.println(vce.getNewValue());
        getRip().setValue(null);
//        AdfFacesContext.getCurrentInstance().addPartialTarget(getRip());
    }

    public void setRip(RichInputText rip) {
        this.rip = rip;
    }

    public RichInputText getRip() {
        return rip;
    }

    public void doERPSolValidateIMEI(ValueChangeEvent o) {
        String message;
    try {
           message =  o.getNewValue().toString();
        } catch (Exception e) {
            // TODO: Add catch code
//        System.out.println("this is oo");
        e.printStackTrace();
            return;
        }
    //    if (message.length()!=15) {
    //            return;
    //       }
    //    System.out.println(message);
        Row ERPsolrow=ERPSolvoImei.createRow();
        ERPsolrow.setAttribute("ImeiNo", message); 
        ERPSolvoImei.insertRow(ERPsolrow);
        ERPSolvoImei.setCurrentRow(ERPsolrow);
        AdfFacesContext.getCurrentInstance().addPartialTarget(getERPSolTotalImei());
        OperationBinding binding =ERPSolGlobalViewBean.doIsERPSolGerOperationBinding("Commit") ;
        binding.execute();
        List errors = binding.getErrors();
        if (!errors.isEmpty()) {
           ERPSolvoImei.getCurrentRow().remove();
           binding.execute();
           String inputId = "it2"; //here it6 is id for inputtext in1st column.
           //        System.out.println("inputid "+inputId);
           FacesContext facesCtx=FacesContext.getCurrentInstance();
           ExtendedRenderKitService service = Service.getRenderKitService(facesCtx, ExtendedRenderKitService.class);
           service.addScript(facesCtx, "comp = AdfPage.PAGE.findComponent('"+inputId+"');\n" +
           "comp.focus()");      // javascript            
           return;
       }


        if(getERPSolTotalImei().getValue().toString().equals(getERPSolPerBox().toString()))
      {
            
        String inputId = "it5"; //here it6 is id for inputtext in1st column.
    //        System.out.println("inputid "+inputId);
        FacesContext facesCtx=FacesContext.getCurrentInstance();
        ExtendedRenderKitService service = Service.getRenderKitService(facesCtx, ExtendedRenderKitService.class);
        service.addScript(facesCtx, "comp = AdfPage.PAGE.findComponent('"+inputId+"');\n" +
        "comp.focus()");      // javascript method is used
        
        }
    }
    public void handleEnterEvent(ClientEvent ce) {
        try{
            
        
    String message = (String) ce.getParameters().get("fvalue");
    if (getERPImeiSerial().equals("S")) {
           ERPSolSerialImei.setNamedWhereClauseParam("P_ADF_SERIAL_NO", message);
           ERPSolSerialImei.executeQuery();
           
           try {
                message = ERPSolSerialImei.first().getAttribute("Imei").toString();
            } catch (Exception e) {
                // TODO: Add catch code
                String inputId = "it2"; //here it6 is id for inputtext in1st column.
                //        System.out.println("inputid "+inputId);
                FacesContext facesCtx=FacesContext.getCurrentInstance();
                ExtendedRenderKitService service = Service.getRenderKitService(facesCtx, ExtendedRenderKitService.class);
                service.addScript(facesCtx, "comp = AdfPage.PAGE.findComponent('"+inputId+"');\n" +
                "comp.focus()");
                e.printStackTrace();
            }
       }
        Row ERPsolrow=ERPSolvoImei.createRow();
        ERPsolrow.setAttribute("ImeiNo", message); 
        ERPSolvoImei.insertRow(ERPsolrow);
        ERPSolvoImei.setCurrentRow(ERPsolrow);
        AdfFacesContext.getCurrentInstance().addPartialTarget(getERPSolTotalImei());
        OperationBinding binding =ERPSolGlobalViewBean.doIsERPSolGerOperationBinding("Commit") ;
        binding.execute();
        List errors = binding.getErrors();
        if (!errors.isEmpty()) {
           ERPSolvoImei.getCurrentRow().remove();
           binding.execute();
           String inputId = "it2"; //here it6 is id for inputtext in1st column.
           //        System.out.println("inputid "+inputId);
           FacesContext facesCtx=FacesContext.getCurrentInstance();
           ExtendedRenderKitService service = Service.getRenderKitService(facesCtx, ExtendedRenderKitService.class);
           service.addScript(facesCtx, "comp = AdfPage.PAGE.findComponent('"+inputId+"');\n" +
           "comp.focus()");            
           return;
       }


        if(getERPSolTotalImei().getValue().toString().equals(getERPSolPerBox().toString()))
      {
            
        String inputId = "it5"; //here it6 is id for inputtext in1st column.
        FacesContext facesCtx=FacesContext.getCurrentInstance();
        ExtendedRenderKitService service = Service.getRenderKitService(facesCtx, ExtendedRenderKitService.class);
        service.addScript(facesCtx, "comp = AdfPage.PAGE.findComponent('"+inputId+"');\n" +
        "comp.focus()");      // javascript method is used
        
        }
        }
        catch(Exception erpexc) {
            erpexc.printStackTrace();
        }
        
    }

    public void handleEnterRepackEvent(ClientEvent ce) {
        
        String message = (String) ce.getParameters().get("fvalue");
        if (message.trim().length()==0) {
          System.out.println("calling"+message.length());
           return;
        }
        
        DBTransaction dbt=(DBTransaction)ERPSolAM.getTransaction();
        CallableStatement cs=null;
        OperationBinding binding=ERPSolGlobalViewBean.doIsERPSolGerOperationBinding("Commit") ;
        
        try{
            
        System.out.println("repack 1");
    
    if (getERPImeiSerial().equals("S")) {
           System.out.println("repack 2");
           ERPSolSerialImei.setNamedWhereClauseParam("P_ADF_SERIAL_NO", message);
           System.out.println("repack 3");
           ERPSolSerialImei.executeQuery();
           
           try {
                message = ERPSolSerialImei.first().getAttribute("Imei").toString();
            } catch (Exception e) {
                // TODO: Add catch code
                doERPSolGotoErrorTextItem();
            }
       }
        System.out.println("begin ?:=pkg_warranty_card.FUNC_INSERT_REPACK_IMEI('"+message+"','"+ERPSolvoBox.getCurrentRow().getAttribute("Spboxseq")+"','"+ERPSolGlobClassModel.doGetUserCode()+"'); end;");
            
        cs=dbt.createCallableStatement("begin ?:=pkg_warranty_card.FUNC_INSERT_REPACK_IMEI('"+message+"','"+ERPSolvoBox.getCurrentRow().getAttribute("Spboxseq")+"','"+ERPSolGlobClassModel.doGetUserCode()+"'); end;", DBTransaction.DEFAULT);
        cs.registerOutParameter(1, Types.VARCHAR);
        cs.executeUpdate();
        
            if (!cs.getString(1).equals("ERPSOLSUCCESS")) {
                    binding.execute();
                    doERPSolGotoErrorTextItem();
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(cs.getString(1)));
                    return;
                }
            
                
            System.out.println("repack -five");
        Row ERPsolrow=ERPSolvoImei.createRow();
            System.out.println("repack -sox");
        ERPsolrow.setAttribute("ImeiNo", message); 
            System.out.println("repack -seven");
        ERPSolvoImei.insertRow(ERPsolrow);
            System.out.println("repack -eight");
        ERPSolvoImei.setCurrentRow(ERPsolrow);
        AdfFacesContext.getCurrentInstance().addPartialTarget(getERPSolTotalImei());
        binding.execute();
        List errors = binding.getErrors();
        if (!errors.isEmpty()) {
           ERPSolvoImei.getCurrentRow().remove();
           binding.execute();
           doERPSolGotoErrorTextItem();
           return;
       }


        if(getERPSolTotalImei().getValue().toString().equals(getERPSolPerBox().toString()))
      {
            
        String inputId = "it5"; //here it6 is id for inputtext in1st column.
        FacesContext facesCtx=FacesContext.getCurrentInstance();
        ExtendedRenderKitService service = Service.getRenderKitService(facesCtx, ExtendedRenderKitService.class);
        service.addScript(facesCtx, "comp = AdfPage.PAGE.findComponent('"+inputId+"');\n" +
        "comp.focus()");      // javascript method is used
        
        }
        }
        catch(Exception erpexc) {
            erpexc.printStackTrace();
        }
        finally{
            try {
                cs.close();
            } catch (SQLException e) {
            }
        }
        
    }



    
  
      public void handleEnterEventBox(ClientEvent ce) {
    
    try{
        String message = (String) ce.getParameters().get("fvalue");
        Row ERPsolrow=ERPSolvoBox.createRow();
        ERPsolrow.setAttribute("Boxno", message);
        ERPSolvoBox.insertRow(ERPsolrow);
        ERPSolvoBox.setCurrentRow(ERPsolrow);
        OperationBinding binding =ERPSolGlobalViewBean.doIsERPSolGerOperationBinding("Commit") ;
        binding.execute();
           List errors = binding.getErrors();
           if (!errors.isEmpty()) {
              ERPSolvoBox.getCurrentRow().remove();
               binding.execute();
               String inputId = "it2"; //here it6 is id for inputtext in1st column.
               FacesContext facesCtx=FacesContext.getCurrentInstance();
               ExtendedRenderKitService service = Service.getRenderKitService(facesCtx, ExtendedRenderKitService.class);
               service.addScript(facesCtx, "comp = AdfPage.PAGE.findComponent('"+inputId+"');\n" +
               "comp.focus()");      // javascript            
              return;
           }
        
           String inputId = "it100"; //here it6 is id for inputtext in1st column.
           FacesContext facesCtx=FacesContext.getCurrentInstance();
           ExtendedRenderKitService service = Service.getRenderKitService(facesCtx, ExtendedRenderKitService.class);
           service.addScript(facesCtx, "comp = AdfPage.PAGE.findComponent('"+inputId+"');\n" +
           "comp.focus()");      // javascript method is used
    }
    catch(Exception erpexcep) {
        erpexcep.printStackTrace();
    }
       }
  
 
    public void handleEnterEventRepackBox(ClientEvent ce) {
         String message = (String) ce.getParameters().get("fvalue");
   if (message.trim().length()==0) {
           System.out.println("calling"+message.length());
            return;
       }
         DBTransaction dbt=(DBTransaction)ERPSolAM.getTransaction();
         CallableStatement cs=null;
         OperationBinding binding=null;
    try{
      
//        System.out.println(message.length() + "msglength");
        if (message.length()==0) {
               return;
//               System.out.println(message.length() + "msglength-1");
//                doERPSolGotoErrorTextItem();
//               System.out.println(message.length() + "msglength-2");
//                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Please Enter Box No."));
                
           }
      Row ERPsolrow=ERPSolvoBox.createRow();
      ERPsolrow.setAttribute("Boxno", message);
      ERPSolvoBox.insertRow(ERPsolrow);
      ERPSolvoBox.setCurrentRow(ERPsolrow);
      binding =ERPSolGlobalViewBean.doIsERPSolGerOperationBinding("Commit") ;
      binding.execute();
         List errors = binding.getErrors();
         if (!errors.isEmpty()) {
            ERPSolvoBox.getCurrentRow().remove();
             binding.execute();
             doERPSolGotoErrorTextItem();
            return;
         }
        
        cs=dbt.createCallableStatement("begin ?:=pkg_warranty_card.func_insert_repack_imei_by_box('"+ERPSolvoBox.getCurrentRow().getAttribute("Pckid")+"','"+ERPSolvoBox.getCurrentRow().getAttribute("Spboxseq")+"','"+ERPSolGlobClassModel.doGetUserCode()+"'); end;", DBTransaction.DEFAULT);
        System.out.println("begin ?:=pkg_warranty_card.func_insert_repack_imei_by_box('"+ERPSolvoBox.getCurrentRow().getAttribute("Pckid")+"','"+ERPSolvoBox.getCurrentRow().getAttribute("Spboxseq")+"','"+ERPSolGlobClassModel.doGetUserCode()+"'); end;");
//        System.out.println("begin ?:=pkg_warranty_card.func_insert_repack_imei_by_box('"+ERPSolvoBox.getCurrentRow().getAttribute("Pckid")+"','"+ERPSolvoBox.getCurrentRow().getAttribute("Spboxseq")+"','"+ERPSolGlobClassModel.doGetUserCode()+"'); end;");
        cs.registerOutParameter(1, Types.VARCHAR);
        cs.executeUpdate();
        dbt.commit();
        if (!cs.getString(1).equals("ERPSOLSUCCESS")) {
                ERPSolvoBox.getCurrentRow().remove();
                binding.execute();
                doERPSolGotoErrorTextItem();
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(cs.getString(1)));
                return;
            }
         ERPSolvoImei.executeQuery();
            if (ERPSolvoImei.getEstimatedRowCount()==0) {
                String inputId = "it100"; //here it6 is id for inputtext in1st column.
                FacesContext facesCtx = FacesContext.getCurrentInstance();
                ExtendedRenderKitService service =
                    Service.getRenderKitService(facesCtx, ExtendedRenderKitService.class);
                service.addScript(facesCtx, "comp = AdfPage.PAGE.findComponent('" + inputId + "');\n" + "comp.focus()");
            }     // javascript method is used
    }
    catch(Exception erpexcep) {//for error cursor should move to it2 field
        ERPSolvoBox.getCurrentRow().remove();
        binding.execute();
        doERPSolGotoErrorTextItem();// javascript            
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(erpexcep.getMessage()));
        erpexcep.printStackTrace();
    }
    finally{
        try {
                cs.close();
            } catch (SQLException sqle) {
                // TODO: Add catch code
//                sqle.printStackTrace();
            }
    }
     }
       
    public void doERPSolValidateBox(ValueChangeEvent ce) {
           String message;
           try {
              message =  ce.getNewValue().toString();
           } catch (Exception e) {
               // TODO: Add catch code
           //        System.out.println("this is oo");
           e.printStackTrace();
               return;
           }

//           System.out.println("zero"+ERPSolvoBox);
//           System.out.println("one"+ERPSolvoBox);
        Row ERPsolrow=ERPSolvoBox.createRow();
//           System.out.println("on2");
        ERPsolrow.setAttribute("Boxno", message);
//           System.out.println("THREE");
        ERPSolvoBox.insertRow(ERPsolrow);
//           System.out.println("onFOUR");
        ERPSolvoBox.setCurrentRow(ERPsolrow);
//        System.out.println("six");
        OperationBinding binding =ERPSolGlobalViewBean.doIsERPSolGerOperationBinding("Commit") ;
//           System.out.println("seven");
        binding.execute();
//           System.out.println("eight");
           List errors = binding.getErrors();
           if (!errors.isEmpty()) {
              ERPSolvoBox.getCurrentRow().remove();
               binding.execute();
               String inputId = "it2"; //here it6 is id for inputtext in1st column.
               //        System.out.println("inputid "+inputId);
               FacesContext facesCtx=FacesContext.getCurrentInstance();
               ExtendedRenderKitService service = Service.getRenderKitService(facesCtx, ExtendedRenderKitService.class);
               service.addScript(facesCtx, "comp = AdfPage.PAGE.findComponent('"+inputId+"');\n" +
               "comp.focus()");      // javascript            
              return;
           }
        
           String inputId = "it100"; //here it6 is id for inputtext in1st column.
           FacesContext facesCtx=FacesContext.getCurrentInstance();
           ExtendedRenderKitService service = Service.getRenderKitService(facesCtx, ExtendedRenderKitService.class);
           service.addScript(facesCtx, "comp = AdfPage.PAGE.findComponent('"+inputId+"');\n" +
           "comp.focus()");      // javascript method is used
           
//        ERPSolvo.getApplicationModule().getTransaction().commit();
        
        
        
       }
    public static void main(String[] args) throws Exception{
        System.out.println(new Date().getCurrentDate());
        String pDate="2021-03-11";
        Calendar calendar = Calendar.getInstance();
        java.util.Date UtilDate = new SimpleDateFormat("yyyy-MM-dd").parse(pDate);
        calendar.setTime(UtilDate);
        String smonth="";
        String emonth="";
        String eday  ="";
        String eyear="";
        String syear="";
        java.util.Date WtyStart;
       java.util.Date  WtyEnd;
        Integer day=calendar.get(Calendar.DAY_OF_MONTH);
        
       if (day<11) {
           calendar.add(Calendar.MONTH, 1);
       }
       else {
           calendar.add(Calendar.MONTH, 2);
       }
//       calendar.add(Calendar.MONTH, 1);
       syear=""+calendar.get(Calendar.YEAR);
       
       smonth=""+ (calendar.get(Calendar.MONTH)+1);
       WtyStart=new SimpleDateFormat("yyyy-MM-dd").parse(syear+"-"+smonth+"-01");
       calendar.add(Calendar.MONTH, 11);
       eyear=""+(calendar.get(Calendar.YEAR));
       eday=""+calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
       
       emonth=""+(calendar.get(Calendar.MONTH)+1);
       
       WtyEnd=new SimpleDateFormat("yyyy-MM-dd").parse(eyear+"-"+emonth+"-"+eday);
       
     
       
       java.sql.Date sqlStartDate = new java.sql.Date(WtyStart.getTime());
       java.sql.Date sqlEndate = new java.sql.Date(WtyEnd.getTime());
       
       Date jboStartDate = new oracle.jbo.domain.Date(sqlStartDate);
       Date jboEndDate = new oracle.jbo.domain.Date(sqlEndate);
       
       System.out.println(jboStartDate);
       System.out.println(jboEndDate);
       
       
        if (1==1) {
            return;
       }
      
        if (day<11) {
            calendar.add(Calendar.MONTH, 1);
           syear=""+calendar.get(Calendar.YEAR);
           
           smonth=""+ (calendar.get(Calendar.MONTH)+1);
           smonth=""+new SimpleDateFormat("yyyy-MM-dd").parse(syear+"-"+smonth+"-01");
           calendar.add(Calendar.MONTH, 11);
           eyear=""+(calendar.get(Calendar.YEAR));
           eday=""+calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
           
           emonth=""+(calendar.get(Calendar.MONTH)+1);
           
           emonth=""+new SimpleDateFormat("yyyy-MM-dd").parse(eyear+"-"+emonth+"-"+eday); 
        
       }
       else {

            calendar.add(Calendar.MONTH, 2);
            syear=""+calendar.get(Calendar.YEAR);
            smonth=""+ (calendar.get(Calendar.MONTH)+1);
            smonth=""+new SimpleDateFormat("yyyy-MM-dd").parse(syear+"-"+smonth+"-01");
            calendar.add(Calendar.MONTH, 11);
            eyear=""+(calendar.get(Calendar.YEAR));
            eday=""+calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
            emonth=""+(calendar.get(Calendar.MONTH)+1);
            emonth=""+new SimpleDateFormat("yyyy-MM-dd").parse(eyear+"-"+emonth+"-"+eday);   
            
        }
        System.out.println(smonth);
       System.out.println(emonth);
   }

    public void setERPSolTotalImei(RichOutputText ERPSolTotalImei) {
        this.ERPSolTotalImei = ERPSolTotalImei;
    }

    public RichOutputText getERPSolTotalImei() {
        return ERPSolTotalImei;
    }


    public void setERPSolPerBox(Integer ERPSolPerBox) {
        this.ERPSolPerBox = ERPSolPerBox;
    }

    public Integer getERPSolPerBox() {
        return ERPSolPerBox;
    }
    
    public String ERPSoldoAssignBindigs(){
        OperationBinding binding = ERPSolGlobalViewBean.doIsERPSolGerOperationBinding("Commit");
        binding.execute();
        
        BindingContainer bc = ERPSolGlobalViewBean.doGetERPBindings();
        
        
        DCIteratorBinding ib=(DCIteratorBinding)bc.get("InSetPackingCRUDIterator");
        ApplicationModule am=ib.getViewObject().getApplicationModule();
        ViewObject vo=am.findViewObject("QVOWCP");
        if (vo!=null) {
            vo.remove();
        }
        
        vo=am.createViewObjectFromQueryStmt("QVOWCP", "select PARAMETER_VALUE FROM so_sales_parameter a where a.Parameter_Id='FORM_SERVER_URL'");
        vo.executeQuery();
        String pReportUrl=vo.first().getAttribute(0).toString();
        vo.remove();
        vo=am.createViewObjectFromQueryStmt("QVOWCP", "select PATH PATH FROM SYSTEM a where a.PROJECTID='WTY' ");
        vo.executeQuery();
        String PFormURL=vo.first().getAttribute(0).toString()+"FORMS\\\\";
        System.out.println(PFormURL);
        PFormURL=PFormURL+"WTY_PACKING_FRESH.fmx";
        
        
        BindingContainer ERPSolbc=ERPSolGlobalViewBean.doGetERPBindings();
        System.out.println("b");
        //        AttributeBinding ERPCompanyid       =(AttributeBinding)ERPSolbc.getControlBinding("Companyid");
        AttributeBinding ERPPackingid        =(AttributeBinding)ERPSolbc.getControlBinding("Pckid");
        AttributeBinding ERPPackingseq        =(AttributeBinding)ERPSolbc.getControlBinding("Packingseq");
        
        String reportParameter="";
        //        reportParameter="COMPANY="+ (ERPCompanyid.getInputValue()==null?"":ERPCompanyid.getInputValue());
        
        pReportUrl=pReportUrl.replace("<P_FORM_NAME>", PFormURL);
        pReportUrl=pReportUrl.replace("<P_PRIMARY_KEY>", ERPPackingseq.getInputValue().toString());
        pReportUrl=pReportUrl.replace("<P_USERID>", ERPSolGlobClassModel.doGetUserCode());
        
        System.out.println(PFormURL);
        System.out.println(reportParameter);
        System.out.println(pReportUrl);
        
        doErpSolOpenReportTab(pReportUrl);                                           
                                           
        return null;
    }

    /* 
    public String  ERPSoldoAssignBindigs() {
        
         ERPSolbc = ERPSolGlobalViewBean.doGetERPBindings();
         ERPSolibImei=(DCIteratorBinding)ERPSolbc.get("InSpdetlDetCRUDIterator");
         ERPSolvoImei=ERPSolibImei.getViewObject();
         ERPSolAM = ERPSolvoImei.getApplicationModule();
         ERPSolSerialImei=ERPSolAM.findViewObject("VWImeiBySerialNoRO");
         ERPSolibBox=(DCIteratorBinding)ERPSolbc.get("InSpboxDetCRUDIterator");
         ERPSolvoBox=ERPSolibBox.getViewObject();
        

         return "ACT-ERP-WTY-0007-SCAN";
    } */

    public String  ERPSoldoAssignRepackBindigs() {
         ERPSolbc = ERPSolGlobalViewBean.doGetERPBindings();
         ERPSolibImei=(DCIteratorBinding)ERPSolbc.get("InSpdetlRepackDetCRUDIterator");
         ERPSolvoImei=ERPSolibImei.getViewObject();
         ERPSolAM = ERPSolvoImei.getApplicationModule();
         ERPSolSerialImei=ERPSolAM.findViewObject("VWImeiBySerialNoRO");
         ERPSolibBox=(DCIteratorBinding)ERPSolbc.get("InSpboxRepackDetCRUDIterator");
         ERPSolvoBox=ERPSolibBox.getViewObject();
        
    //        getERPSolBoxScanned().clear();
    //        getERPSolImeiScanned().clear();
         return "ACT-ERP-WTY-0002-SCAN";
    }


    public void setERPSolImeiStr(String ERPSolImeiStr) {
        this.ERPSolImeiStr = null;
    }

    public String getERPSolImeiStr() {
        return null;
    }

    public void setERPSolBoxStr(String ERPSolBoxStr) {
        this.ERPSolBoxStr = null;
    }

    public String getERPSolBoxStr() {
        return null;
    }

    public void setERPImeiSerial(String ERPImeiSerial) {
        this.ERPImeiSerial = ERPImeiSerial;
    }

    public String getERPImeiSerial() {
        return ERPImeiSerial;
    }
    public void doERPSolGotoErrorTextItem() {
        String inputId = "it2"; //here it6 is id for inputtext in1st column.
        FacesContext facesCtx=FacesContext.getCurrentInstance();
        ExtendedRenderKitService service = Service.getRenderKitService(facesCtx, ExtendedRenderKitService.class);
        service.addScript(facesCtx, "comp = AdfPage.PAGE.findComponent('"+inputId+"');\n" +
        "comp.focus()");      // javascript            

    }
}
