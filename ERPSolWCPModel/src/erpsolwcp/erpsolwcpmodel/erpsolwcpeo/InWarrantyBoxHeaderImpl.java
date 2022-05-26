package erpsolwcp.erpsolwcpmodel.erpsolwcpeo;

import erpsolglob.erpsolglobmodel.erpsolglobclasses.ERPSolGlobClassModel;
import erpsolglob.erpsolglobmodel.erpsolglobclasses.ERPSolGlobalsEntityImpl;

import java.math.BigDecimal;

import java.sql.Timestamp;

import oracle.jbo.AttributeList;
import oracle.jbo.Key;
import oracle.jbo.RowIterator;
import oracle.jbo.domain.Date;
import oracle.jbo.server.EntityDefImpl;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.TransactionEvent;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Thu May 26 13:35:26 PKT 2022
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class InWarrantyBoxHeaderImpl extends ERPSolGlobalsEntityImpl {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        Boxheaderseq,
        DocumentId,
        DocumentDate,
        Itemid,
        BoxNo,
        Lineno,
        CreatedDate,
        CreatedBy,
        ModifiedBy,
        ModifiedDate,
        Submit,
        Locationid,
        txtItemName,
        Remarks,
        InWarrantyBoxLines,
        InItems;
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


    public static final int BOXHEADERSEQ = AttributesEnum.Boxheaderseq.index();
    public static final int DOCUMENTID = AttributesEnum.DocumentId.index();
    public static final int DOCUMENTDATE = AttributesEnum.DocumentDate.index();
    public static final int ITEMID = AttributesEnum.Itemid.index();
    public static final int BOXNO = AttributesEnum.BoxNo.index();
    public static final int LINENO = AttributesEnum.Lineno.index();
    public static final int CREATEDDATE = AttributesEnum.CreatedDate.index();
    public static final int CREATEDBY = AttributesEnum.CreatedBy.index();
    public static final int MODIFIEDBY = AttributesEnum.ModifiedBy.index();
    public static final int MODIFIEDDATE = AttributesEnum.ModifiedDate.index();
    public static final int SUBMIT = AttributesEnum.Submit.index();
    public static final int LOCATIONID = AttributesEnum.Locationid.index();
    public static final int TXTITEMNAME = AttributesEnum.txtItemName.index();
    public static final int REMARKS = AttributesEnum.Remarks.index();
    public static final int INWARRANTYBOXLINES = AttributesEnum.InWarrantyBoxLines.index();
    public static final int INITEMS = AttributesEnum.InItems.index();

    /**
     * This is the default constructor (do not remove).
     */
    public InWarrantyBoxHeaderImpl() {
    }

    /**
     * @return the definition object for this instance class.
     */
    public static synchronized EntityDefImpl getDefinitionObject() {
        return EntityDefImpl.findDefObject("erpsolwcp.erpsolwcpmodel.erpsolwcpeo.InWarrantyBoxHeader");
    }


    /**
     * Gets the attribute value for Boxheaderseq, using the alias name Boxheaderseq.
     * @return the value of Boxheaderseq
     */
    public Integer getBoxheaderseq() {
        return (Integer) getAttributeInternal(BOXHEADERSEQ);
    }

    /**
     * Sets <code>value</code> as the attribute value for Boxheaderseq.
     * @param value value to set the Boxheaderseq
     */
    public void setBoxheaderseq(Integer value) {
        setAttributeInternal(BOXHEADERSEQ, value);
    }

    /**
     * Gets the attribute value for DocumentId, using the alias name DocumentId.
     * @return the value of DocumentId
     */
    public String getDocumentId() {
        return (String) getAttributeInternal(DOCUMENTID);
    }

    /**
     * Sets <code>value</code> as the attribute value for DocumentId.
     * @param value value to set the DocumentId
     */
    public void setDocumentId(String value) {
        setAttributeInternal(DOCUMENTID, value);
    }

    /**
     * Gets the attribute value for DocumentDate, using the alias name DocumentDate.
     * @return the value of DocumentDate
     */
    public Date getDocumentDate() {
        return (Date) getAttributeInternal(DOCUMENTDATE);
    }

    /**
     * Sets <code>value</code> as the attribute value for DocumentDate.
     * @param value value to set the DocumentDate
     */
    public void setDocumentDate(Date value) {
        setAttributeInternal(DOCUMENTDATE, value);
    }

    /**
     * Gets the attribute value for Itemid, using the alias name Itemid.
     * @return the value of Itemid
     */
    public String getItemid() {
        return (String) getAttributeInternal(ITEMID);
    }

    /**
     * Sets <code>value</code> as the attribute value for Itemid.
     * @param value value to set the Itemid
     */
    public void setItemid(String value) {
        setAttributeInternal(ITEMID, value);
    }

    /**
     * Gets the attribute value for BoxNo, using the alias name BoxNo.
     * @return the value of BoxNo
     */
    public String getBoxNo() {
        return (String) getAttributeInternal(BOXNO);
    }

    /**
     * Sets <code>value</code> as the attribute value for BoxNo.
     * @param value value to set the BoxNo
     */
    public void setBoxNo(String value) {
        setAttributeInternal(BOXNO, value);
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
     * Gets the attribute value for CreatedBy, using the alias name CreatedBy.
     * @return the value of CreatedBy
     */
    public String getCreatedBy() {
        return (String) getAttributeInternal(CREATEDBY);
    }

    /**
     * Sets <code>value</code> as the attribute value for CreatedBy.
     * @param value value to set the CreatedBy
     */
    public void setCreatedBy(String value) {
        setAttributeInternal(CREATEDBY, value);
    }

    /**
     * Gets the attribute value for ModifiedBy, using the alias name ModifiedBy.
     * @return the value of ModifiedBy
     */
    public String getModifiedBy() {
        return (String) getAttributeInternal(MODIFIEDBY);
    }

    /**
     * Sets <code>value</code> as the attribute value for ModifiedBy.
     * @param value value to set the ModifiedBy
     */
    public void setModifiedBy(String value) {
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
     * Gets the attribute value for Submit, using the alias name Submit.
     * @return the value of Submit
     */
    public String getSubmit() {
        return (String) getAttributeInternal(SUBMIT);
    }

    /**
     * Sets <code>value</code> as the attribute value for Submit.
     * @param value value to set the Submit
     */
    public void setSubmit(String value) {
        setAttributeInternal(SUBMIT, value);
    }

    /**
     * Gets the attribute value for Locationid, using the alias name Locationid.
     * @return the value of Locationid
     */
    public String getLocationid() {
        return (String) getAttributeInternal(LOCATIONID);
    }

    /**
     * Sets <code>value</code> as the attribute value for Locationid.
     * @param value value to set the Locationid
     */
    public void setLocationid(String value) {
        setAttributeInternal(LOCATIONID, value);
    }

    /**
     * Gets the attribute value for txtItemName, using the alias name txtItemName.
     * @return the value of txtItemName
     */
    public String gettxtItemName() {
        return (String) getAttributeInternal(TXTITEMNAME);
    }

    /**
     * Sets <code>value</code> as the attribute value for txtItemName.
     * @param value value to set the txtItemName
     */
    public void settxtItemName(String value) {
        setAttributeInternal(TXTITEMNAME, value);
    }

    /**
     * Gets the attribute value for Remarks, using the alias name Remarks.
     * @return the value of Remarks
     */
    public String getRemarks() {
        return (String) getAttributeInternal(REMARKS);
    }

    /**
     * Sets <code>value</code> as the attribute value for Remarks.
     * @param value value to set the Remarks
     */
    public void setRemarks(String value) {
        setAttributeInternal(REMARKS, value);
    }

    /**
     * @return the associated entity oracle.jbo.RowIterator.
     */
    public RowIterator getInWarrantyBoxLines() {
        return (RowIterator) getAttributeInternal(INWARRANTYBOXLINES);
    }


    /**
     * @return the associated entity oracle.jbo.server.EntityImpl.
     */
    public EntityImpl getInItems() {
        return (EntityImpl) getAttributeInternal(INITEMS);
    }

    /**
     * Sets <code>value</code> as the associated entity oracle.jbo.server.EntityImpl.
     */
    public void setInItems(EntityImpl value) {
        setAttributeInternal(INITEMS, value);
    }


    /**
     * @param boxheaderseq key constituent

     * @return a Key object based on given key constituents.
     */
    public static Key createPrimaryKey(Integer boxheaderseq) {
        return new Key(new Object[] { boxheaderseq });
    }

    /**
     * Add attribute defaulting logic in this method.
     * @param attributeList list of attribute names/values to initialize the row
     */
    protected void create(AttributeList attributeList) {
        setERPSolPKColumnName("Boxheaderseq");
        setERPSolPKSeqName("IN_WARRANTY_BOX_HEADER_SEQ");
        setLocationid(ERPSolGlobClassModel.doGetUserLocationCode());
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
        if (operation==DML_INSERT) {
            System.out.println("in set pack insert");
            String pkValue=" func_get_warranty_box_id('"+ERPSolGlobClassModel.doGetUserCompanyCode()+"','"+ERPSolGlobClassModel.doGetUserLocationCode()+"',TO_DATE('"+getDocumentDate()+"','YYYY-MM-DD'))";
            String result= ERPSolGlobClassModel.doGetERPSolPrimaryKeyValueModel(getDBTransaction(), pkValue, "dual", null, null);
            populateAttributeAsChanged(DOCUMENTID, result);
            
            pkValue=" func_get_warranty_box_no('"+getItemid()+"','"+getLineno()+"',TO_DATE('"+getDocumentDate()+"','YYYY-MM-DD'))";
            result= ERPSolGlobClassModel.doGetERPSolPrimaryKeyValueModel(getDBTransaction(), pkValue, "dual", null, null);
            populateAttributeAsChanged(BOXNO, result);            
        } 
        
        super.doDML(operation, e);
    }
}

