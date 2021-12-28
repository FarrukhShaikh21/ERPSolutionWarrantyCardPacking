package erpsolwcp.erpsolwcpmodel.erpsolwcpeo;

import erpsolglob.erpsolglobmodel.erpsolglobclasses.ERPSolGlobClassModel;
import erpsolglob.erpsolglobmodel.erpsolglobclasses.ERPSolGlobalsEntityImpl;

import java.math.BigDecimal;

import java.sql.Timestamp;

import oracle.jbo.AttributeList;
import oracle.jbo.Key;
import oracle.jbo.domain.Date;
import oracle.jbo.server.EntityDefImpl;
import oracle.jbo.server.TransactionEvent;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Tue Dec 28 17:38:37 PKT 2021
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class InSpdetlRepackImpl extends ERPSolGlobalsEntityImpl {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        Pckdetlid,
        ImeiNo,
        Code,
        Phoneno,
        Msg,
        Createdby,
        CreatedDate,
        Modifiedby,
        ModifiedDate,
        Storeid,
        Status,
        Incentive,
        IncentiveMsg,
        Chk,
        SerialNo,
        IncPst,
        Spboxseq,
        Spdetlseq,
        InSpboxRepack;
        private static AttributesEnum[] vals = null;
        private static final int firstIndex = 0;

        public int index() {
            return AttributesEnum.firstIndex() + ordinal();
        }

        public static final int firstIndex() {
            return firstIndex;
        }

        public static int count() {
            return AttributesEnum.firstIndex() + AttributesEnum.staticValues().length;
        }

        public static final AttributesEnum[] staticValues() {
            if (vals == null) {
                vals = AttributesEnum.values();
            }
            return vals;
        }
    }


    public static final int PCKDETLID = AttributesEnum.Pckdetlid.index();
    public static final int IMEINO = AttributesEnum.ImeiNo.index();
    public static final int CODE = AttributesEnum.Code.index();
    public static final int PHONENO = AttributesEnum.Phoneno.index();
    public static final int MSG = AttributesEnum.Msg.index();
    public static final int CREATEDBY = AttributesEnum.Createdby.index();
    public static final int CREATEDDATE = AttributesEnum.CreatedDate.index();
    public static final int MODIFIEDBY = AttributesEnum.Modifiedby.index();
    public static final int MODIFIEDDATE = AttributesEnum.ModifiedDate.index();
    public static final int STOREID = AttributesEnum.Storeid.index();
    public static final int STATUS = AttributesEnum.Status.index();
    public static final int INCENTIVE = AttributesEnum.Incentive.index();
    public static final int INCENTIVEMSG = AttributesEnum.IncentiveMsg.index();
    public static final int CHK = AttributesEnum.Chk.index();
    public static final int SERIALNO = AttributesEnum.SerialNo.index();
    public static final int INCPST = AttributesEnum.IncPst.index();
    public static final int SPBOXSEQ = AttributesEnum.Spboxseq.index();
    public static final int SPDETLSEQ = AttributesEnum.Spdetlseq.index();
    public static final int INSPBOXREPACK = AttributesEnum.InSpboxRepack.index();

    /**
     * This is the default constructor (do not remove).
     */
    public InSpdetlRepackImpl() {
    }

    /**
     * @return the definition object for this instance class.
     */
    public static synchronized EntityDefImpl getDefinitionObject() {
        return EntityDefImpl.findDefObject("erpsolwcp.erpsolwcpmodel.erpsolwcpeo.InSpdetlRepack");
    }


    /**
     * Gets the attribute value for Pckdetlid, using the alias name Pckdetlid.
     * @return the value of Pckdetlid
     */
    public String getPckdetlid() {
        return (String) getAttributeInternal(PCKDETLID);
    }

    /**
     * Sets <code>value</code> as the attribute value for Pckdetlid.
     * @param value value to set the Pckdetlid
     */
    public void setPckdetlid(String value) {
        setAttributeInternal(PCKDETLID, value);
    }

    /**
     * Gets the attribute value for ImeiNo, using the alias name ImeiNo.
     * @return the value of ImeiNo
     */
    public String getImeiNo() {
        return (String) getAttributeInternal(IMEINO);
    }

    /**
     * Sets <code>value</code> as the attribute value for ImeiNo.
     * @param value value to set the ImeiNo
     */
    public void setImeiNo(String value) {
        setAttributeInternal(IMEINO, value);
    }

    /**
     * Gets the attribute value for Code, using the alias name Code.
     * @return the value of Code
     */
    public String getCode() {
        return (String) getAttributeInternal(CODE);
    }

    /**
     * Sets <code>value</code> as the attribute value for Code.
     * @param value value to set the Code
     */
    public void setCode(String value) {
        setAttributeInternal(CODE, value);
    }

    /**
     * Gets the attribute value for Phoneno, using the alias name Phoneno.
     * @return the value of Phoneno
     */
    public String getPhoneno() {
        return (String) getAttributeInternal(PHONENO);
    }

    /**
     * Sets <code>value</code> as the attribute value for Phoneno.
     * @param value value to set the Phoneno
     */
    public void setPhoneno(String value) {
        setAttributeInternal(PHONENO, value);
    }

    /**
     * Gets the attribute value for Msg, using the alias name Msg.
     * @return the value of Msg
     */
    public String getMsg() {
        return (String) getAttributeInternal(MSG);
    }

    /**
     * Sets <code>value</code> as the attribute value for Msg.
     * @param value value to set the Msg
     */
    public void setMsg(String value) {
        setAttributeInternal(MSG, value);
    }

    /**
     * Gets the attribute value for Createdby, using the alias name Createdby.
     * @return the value of Createdby
     */
    public String getCreatedby() {
        return (String) getAttributeInternal(CREATEDBY);
    }

    /**
     * Sets <code>value</code> as the attribute value for Createdby.
     * @param value value to set the Createdby
     */
    public void setCreatedby(String value) {
        setAttributeInternal(CREATEDBY, value);
    }

    /**
     * Gets the attribute value for CreatedDate, using the alias name CreatedDate.
     * @return the value of CreatedDate
     */
    public Date getCreatedDate() {
        return (Date) getAttributeInternal(CREATEDDATE);
    }

    /**
     * Sets <code>value</code> as the attribute value for CreatedDate.
     * @param value value to set the CreatedDate
     */
    public void setCreatedDate(Date value) {
        setAttributeInternal(CREATEDDATE, value);
    }

    /**
     * Gets the attribute value for Modifiedby, using the alias name Modifiedby.
     * @return the value of Modifiedby
     */
    public String getModifiedby() {
        return (String) getAttributeInternal(MODIFIEDBY);
    }

    /**
     * Sets <code>value</code> as the attribute value for Modifiedby.
     * @param value value to set the Modifiedby
     */
    public void setModifiedby(String value) {
        setAttributeInternal(MODIFIEDBY, value);
    }

    /**
     * Gets the attribute value for ModifiedDate, using the alias name ModifiedDate.
     * @return the value of ModifiedDate
     */
    public Date getModifiedDate() {
        return (Date) getAttributeInternal(MODIFIEDDATE);
    }

    /**
     * Sets <code>value</code> as the attribute value for ModifiedDate.
     * @param value value to set the ModifiedDate
     */
    public void setModifiedDate(Date value) {
        setAttributeInternal(MODIFIEDDATE, value);
    }

    /**
     * Gets the attribute value for Storeid, using the alias name Storeid.
     * @return the value of Storeid
     */
    public String getStoreid() {
        return (String) getAttributeInternal(STOREID);
    }

    /**
     * Sets <code>value</code> as the attribute value for Storeid.
     * @param value value to set the Storeid
     */
    public void setStoreid(String value) {
        setAttributeInternal(STOREID, value);
    }

    /**
     * Gets the attribute value for Status, using the alias name Status.
     * @return the value of Status
     */
    public String getStatus() {
        return (String) getAttributeInternal(STATUS);
    }

    /**
     * Sets <code>value</code> as the attribute value for Status.
     * @param value value to set the Status
     */
    public void setStatus(String value) {
        setAttributeInternal(STATUS, value);
    }

    /**
     * Gets the attribute value for Incentive, using the alias name Incentive.
     * @return the value of Incentive
     */
    public BigDecimal getIncentive() {
        return (BigDecimal) getAttributeInternal(INCENTIVE);
    }

    /**
     * Sets <code>value</code> as the attribute value for Incentive.
     * @param value value to set the Incentive
     */
    public void setIncentive(BigDecimal value) {
        setAttributeInternal(INCENTIVE, value);
    }

    /**
     * Gets the attribute value for IncentiveMsg, using the alias name IncentiveMsg.
     * @return the value of IncentiveMsg
     */
    public String getIncentiveMsg() {
        return (String) getAttributeInternal(INCENTIVEMSG);
    }

    /**
     * Sets <code>value</code> as the attribute value for IncentiveMsg.
     * @param value value to set the IncentiveMsg
     */
    public void setIncentiveMsg(String value) {
        setAttributeInternal(INCENTIVEMSG, value);
    }

    /**
     * Gets the attribute value for Chk, using the alias name Chk.
     * @return the value of Chk
     */
    public String getChk() {
        return (String) getAttributeInternal(CHK);
    }

    /**
     * Sets <code>value</code> as the attribute value for Chk.
     * @param value value to set the Chk
     */
    public void setChk(String value) {
        setAttributeInternal(CHK, value);
    }

    /**
     * Gets the attribute value for SerialNo, using the alias name SerialNo.
     * @return the value of SerialNo
     */
    public String getSerialNo() {
        return (String) getAttributeInternal(SERIALNO);
    }

    /**
     * Sets <code>value</code> as the attribute value for SerialNo.
     * @param value value to set the SerialNo
     */
    public void setSerialNo(String value) {
        setAttributeInternal(SERIALNO, value);
    }

    /**
     * Gets the attribute value for IncPst, using the alias name IncPst.
     * @return the value of IncPst
     */
    public BigDecimal getIncPst() {
        return (BigDecimal) getAttributeInternal(INCPST);
    }

    /**
     * Sets <code>value</code> as the attribute value for IncPst.
     * @param value value to set the IncPst
     */
    public void setIncPst(BigDecimal value) {
        setAttributeInternal(INCPST, value);
    }

    /**
     * Gets the attribute value for Spboxseq, using the alias name Spboxseq.
     * @return the value of Spboxseq
     */
    public BigDecimal getSpboxseq() {
        return (BigDecimal) getAttributeInternal(SPBOXSEQ);
    }

    /**
     * Sets <code>value</code> as the attribute value for Spboxseq.
     * @param value value to set the Spboxseq
     */
    public void setSpboxseq(BigDecimal value) {
        setAttributeInternal(SPBOXSEQ, value);
    }

    /**
     * Gets the attribute value for Spdetlseq, using the alias name Spdetlseq.
     * @return the value of Spdetlseq
     */
    public BigDecimal getSpdetlseq() {
        return (BigDecimal) getAttributeInternal(SPDETLSEQ);
    }

    /**
     * Sets <code>value</code> as the attribute value for Spdetlseq.
     * @param value value to set the Spdetlseq
     */
    public void setSpdetlseq(BigDecimal value) {
        setAttributeInternal(SPDETLSEQ, value);
    }

    /**
     * @return the associated entity InSpboxRepackImpl.
     */
    public InSpboxRepackImpl getInSpboxRepack() {
        return (InSpboxRepackImpl) getAttributeInternal(INSPBOXREPACK);
    }

    /**
     * Sets <code>value</code> as the associated entity InSpboxRepackImpl.
     */
    public void setInSpboxRepack(InSpboxRepackImpl value) {
        setAttributeInternal(INSPBOXREPACK, value);
    }


    /**
     * @param spdetlseq key constituent

     * @return a Key object based on given key constituents.
     */
    public static Key createPrimaryKey(BigDecimal spdetlseq) {
        return new Key(new Object[] { spdetlseq });
    }

    /**
     * Add attribute defaulting logic in this method.
     * @param attributeList list of attribute names/values to initialize the row
     */
    protected void create(AttributeList attributeList) {
        setERPSolPKColumnName("Spdetlseq");
        setERPSolPKSeqName("IN_SPDETL_SEQ");    
        setStoreid(ERPSolGlobClassModel.doGetUserStoreCode());        
        super.create(attributeList);
    }

    /**
     * Add entity remove logic in this method.
     */
    public void remove() {
        super.remove();
    }

    /**
     * Add locking logic here.
     */
    public void lock() {
        super.lock();
    }

    /**
     * Custom DML update/insert/delete logic here.
     * @param operation the operation type
     * @param e the transaction event
     */
    protected void doDML(int operation, TransactionEvent e) {
        super.doDML(operation, e);
    }
}

