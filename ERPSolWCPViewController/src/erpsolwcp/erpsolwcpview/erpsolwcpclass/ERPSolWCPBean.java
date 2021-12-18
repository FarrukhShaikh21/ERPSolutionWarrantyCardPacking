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
    List<String> ERPSolImeiScanned=new ArrayList<String>();
    List<String> ERPSolBoxScanned=new ArrayList<String>();
    
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

    public void handleEnterEvent(ClientEvent ce) {
    String message = (String) ce.getParameters().get("fvalue");
//    if (message.length()!=15) {
//            return;
//       }
//    System.out.println(message);
    ERPSolImeiScanned.add("0");
        if(ERPSolImeiScanned.size()>0) {
            for (int i = 0; i < ERPSolImeiScanned.size(); i++) {
                if (message.equals(ERPSolImeiScanned.get(i).toString())) {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("This IMEI Is Already Scanned("+message+")" ));
                    return;
               }
           }

        }
        ERPSolImeiScanned.add(message);
        BindingContainer bc = ERPSolGlobalViewBean.doGetERPBindings();
        DCIteratorBinding ib=(DCIteratorBinding)bc.get("InSpdetlDetCRUDIterator");
        ViewObject ERPSolvo=ib.getViewObject();
        Row ERPsolrow=ERPSolvo.createRow();
        ERPsolrow.setAttribute("ImeiNo", message); 
        AdfFacesContext.getCurrentInstance().addPartialTarget(getERPSolTotalImei());
        System.out.println(getERPSolTotalImei().getValue()+"gv");
        System.out.println(getERPSolPerBox()+".getValue()");
      if(getERPSolTotalImei().getValue().toString().equals(getERPSolPerBox().toString()))
      {
            OperationBinding binding = ERPSolGlobalViewBean.doIsERPSolGerOperationBinding("Commit");
            binding.execute();
            
        String inputId = "it5"; //here it6 is id for inputtext in1st column.
        System.out.println("inputid "+inputId);
        FacesContext facesCtx=FacesContext.getCurrentInstance();
        ExtendedRenderKitService service = Service.getRenderKitService(facesCtx, ExtendedRenderKitService.class);
        service.addScript(facesCtx, "comp = AdfPage.PAGE.findComponent('"+inputId+"');\n" +
        "comp.focus()");      // javascript method is used
        
        }
    }

      /*  if (ERPSolvo.getRowCount()>0)
        {
            ERPSolvo.first();
        if (ERPSolvo.first().getAttribute("ImeiNo").equals(message)) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("This IMEI IS Already Scanned"));
            return;
        }
        while(ERPSolvo.hasNext()) {
            if (ERPSolvo.next().getAttribute("ImeiNo").equals(message)) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("This IMEI IS Already Scanned"));
                return;
            } 
        }
        }*/
            
//        ERPSolvo.getApplicationModule().getTransaction().commit();
    
    
    public void handleEnterEventBox(ClientEvent ce) {
        System.out.println("box is calling");
    String message = (String) ce.getParameters().get("fvalue");
           System.out.println("box is calling >"+message);
           
           if(ERPSolBoxScanned.size()>0) {
               for (int i = 0; i < ERPSolBoxScanned.size(); i++) {
                   if (message.equals(ERPSolBoxScanned.get(i).toString())) {
                       FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("This BOX Is Already Scanned("+message+")" ));
                       return;
                  }
              }

           }
           ERPSolBoxScanned.add(message);
        BindingContainer bc = ERPSolGlobalViewBean.doGetERPBindings();
           System.out.println("d");
        DCIteratorBinding ib=(DCIteratorBinding)bc.get("InSpboxDetCRUDIterator");
           System.out.println("e");
        ViewObject ERPSolvo=ib.getViewObject();
           System.out.println("f");
        Row ERPsolrow=ERPSolvo.createRow();
           System.out.println("g");
        ERPsolrow.setAttribute("Boxno", message);
           System.out.println("h");
        ERPSolvo.insertRow(ERPsolrow);
        OperationBinding binding = ERPSolGlobalViewBean.doIsERPSolGerOperationBinding("Commit");
        binding.execute();
        
           String inputId = "it100"; //here it6 is id for inputtext in1st column.
           System.out.println("inputid "+inputId);
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

    public void setERPSolImeiScanned(List<String> ERPSolImeiScanned) {
        this.ERPSolImeiScanned = ERPSolImeiScanned;
    }

    public List<String> getERPSolImeiScanned() {
        return ERPSolImeiScanned;
    }
    public void ERPSoldoClearList() {
//        getERPSolBoxScanned().clear();
//        getERPSolImeiScanned().clear();
    }
}
