package erpsolwcp.erpsolwcpmodel.erpsolwcpeo;

import erpsolglob.erpsolglobmodel.erpsolglobclasses.ERPSolGlobClassModel;
import erpsolglob.erpsolglobmodel.erpsolglobclasses.ERPSolGlobalsEntityImpl;

import java.math.BigDecimal;

import java.sql.Timestamp;

import oracle.jbo.AttributeList;
import oracle.jbo.Key;
import oracle.jbo.RowIterator;
import oracle.jbo.server.EntityDefImpl;
import oracle.jbo.server.TransactionEvent;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Tue Dec 28 17:33:09 PKT 2021
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class InSpboxRepackImpl extends ERPSolGlobalsEntityImpl {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        Pckdetlid,
        Boxno,
        Pckid,
        Createdby,
        CreatedDate,
        Modifiedby,
        ModifiedDate,
        Status,
        Storeid,
        Chk,
        TotalImei,
        Spboxseq,
        Packingseq,
        Lineno,
        InSetPackingRepack,
        InSpdetlRepack;
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
    public static final int BOXNO = AttributesEnum.Boxno.index();
    public static final int PCKID = AttributesEnum.Pckid.index();
    public static final int CREATEDBY = AttributesEnum.Createdby.index();
    public static final int CREATEDDATE = AttributesEnum.CreatedDate.index();
    public static final int MODIFIEDBY = AttributesEnum.Modifiedby.index();
    public static final int MODIFIEDDATE = AttributesEnum.ModifiedDate.index();
    public static final int STATUS = AttributesEnum.Status.index();
    public static final int STOREID = AttributesEnum.Storeid.index();
    public static final int CHK = AttributesEnum.Chk.index();
    public static final int TOTALIMEI = AttributesEnum.TotalImei.index();
    public static final int SPBOXSEQ = AttributesEnum.Spboxseq.index();
    public static final int PACKINGSEQ = AttributesEnum.Packingseq.index();
    public static final int LINENO = AttributesEnum.Lineno.index();
    public static final int INSETPACKINGREPACK = AttributesEnum.InSetPackingRepack.index();
    public static final int INSPDETLREPACK = AttributesEnum.InSpdetlRepack.index();

    /**
     * This is the default constructor (do not remove).
     */
    public InSpboxRepackImpl() {
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
     * Gets the attribute value for Boxno, using the alias name Boxno.
     * @return the value of Boxno
     */
    public String getBoxno() {
        return (String) getAttributeInternal(BOXNO);
    }

    /**
     * Sets <code>value</code> as the attribute value for Boxno.
     * @param value value to set the Boxno
     */
    public void setBoxno(String value) {
        setAttributeInternal(BOXNO, value);
    }

    /**
     * Gets the attribute value for Pckid, using the alias name Pckid.
     * @return the value of Pckid
     */
    public String getPckid() {
        return (String) getAttributeInternal(PCKID);
    }

    /**
     * Sets <code>value</code> as the attribute value for Pckid.
     * @param value value to set the Pckid
     */
    public void setPckid(String value) {
        setAttributeInternal(PCKID, value);
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
    public Timestamp getCreatedDate() {
        return (Timestamp) getAttributeInternal(CREATEDDATE);
    }

    /**
     * Sets <code>value</code> as the attribute value for CreatedDate.
     * @param value value to set the CreatedDate
     */
    public void setCreatedDate(Timestamp value) {
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
    public Timestamp getModifiedDate() {
        return (Timestamp) getAttributeInternal(MODIFIEDDATE);
    }

    /**
     * Sets <code>value</code> as the attribute value for ModifiedDate.
     * @param value value to set the ModifiedDate
     */
    public void setModifiedDate(Timestamp value) {
        setAttributeInternal(MODIFIEDDATE, value);
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
     * Gets the attribute value for TotalImei, using the alias name TotalImei.
     * @return the value of TotalImei
     */
    public BigDecimal getTotalImei() {
        return (BigDecimal) getAttributeInternal(TOTALIMEI);
    }

    /**
     * Sets <code>value</code> as the attribute value for TotalImei.
     * @param value value to set the TotalImei
     */
    public void setTotalImei(BigDecimal value) {
        setAttributeInternal(TOTALIMEI, value);
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
     * Gets the attribute value for Packingseq, using the alias name Packingseq.
     * @return the value of Packingseq
     */
    public BigDecimal getPackingseq() {
        return (BigDecimal) getAttributeInternal(PACKINGSEQ);
    }

    /**
     * Sets <code>value</code> as the attribute value for Packingseq.
     * @param value value to set the Packingseq
     */
    public void setPackingseq(BigDecimal value) {
        setAttributeInternal(PACKINGSEQ, value);
    }

    /**
     * Gets the attribute value for Lineno, using the alias name Lineno.
     * @return the value of Lineno
     */
    public Integer getLineno() {
        return (Integer) getAttributeInternal(LINENO);
    }

    /**
     * Sets <code>value</code> as the attribute value for Lineno.
     * @param value value to set the Lineno
     */
    public void setLineno(Integer value) {
        setAttributeInternal(LINENO, value);
    }

    /**
     * @return the associated entity InSetPackingRepackImpl.
     */
    public InSetPackingRepackImpl getInSetPackingRepack() {
        return (InSetPackingRepackImpl) getAttributeInternal(INSETPACKINGREPACK);
    }

    /**
     * Sets <code>value</code> as the associated entity InSetPackingRepackImpl.
     */
    public void setInSetPackingRepack(InSetPackingRepackImpl value) {
        setAttributeInternal(INSETPACKINGREPACK, value);
    }

    /**
     * @return the associated entity oracle.jbo.RowIterator.
     */
    public RowIterator getInSpdetlRepack() {
        return (RowIterator) getAttributeInternal(INSPDETLREPACK);
    }

    /**
     * @param spboxseq key constituent

     * @return a Key object based on given key constituents.
     */
    public static Key createPrimaryKey(BigDecimal spboxseq) {
        return new Key(new Object[] { spboxseq });
    }

    /**
     * @return the definition object for this instance class.
     */
    public static synchronized EntityDefImpl getDefinitionObject() {
        return EntityDefImpl.findDefObject("erpsolwcp.erpsolwcpmodel.erpsolwcpeo.InSpboxRepack");
    }

    /**
     * Add attribute defaulting logic in this method.
     * @param attributeList list of attribute names/values to initialize the row
     */
    protected void create(AttributeList attributeList) {
        setERPSolPKColumnName("Spboxseq");
        setERPSolPKSeqName("IN_SPBOX_SEQ");
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

