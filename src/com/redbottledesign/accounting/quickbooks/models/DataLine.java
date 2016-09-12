package com.redbottledesign.accounting.quickbooks.models;

import com.redbottledesign.accounting.quickbooks.iif.IifExportable;
import com.redbottledesign.accounting.quickbooks.util.IifUtils;

/**
 * The abstract representation of a single data line in a QuickBooks IIF file.
 *
 * @author Guy Paddock (guy@redbottledesign.com)
 */
public abstract class DataLine
implements IifExportable, Cloneable {
    /**
     * The (optional) unique identifier for the transaction.
     */
    private TxnIdentifier id;

    /**
     * The type of transaction.
     */
    private TxnType type;

    /**
     * The date on which the transaction occurred.
     */
    private Date date;

    /**
     * The account (from the Chart of Accounts) affected by this transaction
     * line.
     */
    private Account account;

    /**
     * The (optional) name of the Vendor/Client associated with this transaction
     * line.
     */
    private Name name;

    /**
     * The (optional) class for this transaction line.
     */
    private TxnClass txnClass;

    /**
     * The amount of money credited or debited by this transaction line.
     */
    private Amount amount;

    /**
     * The (optional) identifier for the document (i.e. journal entry ID) that
     * contains the transaction.
     */
    private DocNumber docNumber;

    /**
     * The (optional) memo / notes for this transaction line.
     */
    private Memo memo;

    /**
     * Default constructor for {@link DataLine}.
     */
    public DataLine() {
        this.setId(TxnIdentifier.NULL);
        this.setTxnClass(TxnClass.NULL);
        this.setName(Name.NULL);
        this.setDocNumber(DocNumber.NULL);
        this.setMemo(Memo.NULL);
    }

    /**
     * Gets the (optional) unique identifier for the transaction.
     *
     * <p>All transaction lines in the same transaction must share the same
     * transaction ID.</p>
     *
     * @return  The unique ID of the transaction.
     */
    public TxnIdentifier getId() {
        return this.id;
    }

    /**
     * Sets the unique identifier for the transaction.
     *
     * <p>All transaction lines in the same transaction must share the same
     * transaction ID.</p>
     *
     * @param   id
     *          The new unique ID of the transaction.
     */
    public void setId(final TxnIdentifier id) {
        this.ensureNotNull(id, "id");
        this.id = id;
    }

    /**
     * Gets the type of transaction.
     *
     * <p>All transaction lines in the same transaction must share the same
     * transaction type.</p>
     *
     * @return  The type of the transaction.
     */
    public TxnType getType() {
        return this.type;
    }

    /**
     * Sets the type of transaction.
     *
     * <p>All transaction lines in the same transaction must share the same
     * transaction type.</p>
     *
     * @param   type
     *          The type of the transaction.
     */
    public void setType(final TxnType type) {
        this.ensureNotNull(type, "type");
        this.type = type;
    }

    /**
     * Gets the date on which the transaction occurred.
     *
     * <p>All transaction lines in the same transaction must share the same
     * transaction date.</p>
     *
     * @return  The transaction date.
     */
    public Date getDate() {
        return this.date;
    }

    /**
     * Sets the date on which the transaction occurred.
     *
     * <p>All transaction lines in the same transaction must share the same
     * transaction date.</p>
     *
     * @param   date
     *          The new transaction date.
     */
    public void setDate(final Date date) {
        this.ensureNotNull(date, "date");
        this.date = date;
    }

    /**
     * Gets the account (from the Chart of Accounts) affected by this
     * transaction line.
     *
     * @return  The account affected by this line.
     */
    public Account getAccount() {
        return this.account;
    }

    /**
     * Sets the account (from the Chart of Accounts) affected by this
     * transaction line.
     *
     * @param   account
     *          The new account affected by this line.
     */
    public void setAccount(final Account account) {
        this.ensureNotNull(account, "account");
        this.account = account;
    }

    /**
     * Gets the (optional) name of the Vendor/Client associated with this
     * transaction line.
     *
     * @return  The name associated with this transaction line.
     */
    public Name getName() {
        return this.name;
    }

    /**
     * Sets the name of the Vendor/Client associated with this transaction line.
     *
     * @param   name
     *          The new name associated with this transaction line.
     */
    public void setName(final Name name) {
        this.ensureNotNull(name, "name");
        this.name = name;
    }

    /**
     * Gets the (optional) class for this transaction line.
     *
     * @return  The class on this line.
     */
    public TxnClass getTxnClass() {
        return this.txnClass;
    }

    /**
     * Sets the class for this transaction line.
     *
     * @param   txnClass
     *          The new class for this line.
     */
    public void setTxnClass(final TxnClass txnClass) {
        this.ensureNotNull(txnClass, "txnClass");
        this.txnClass = txnClass;
    }

    /**
     * Gets the amount of money credited or debited by this transaction line.
     *
     * <p>By convention, positive amounts are debits and negative amounts are
     * credits.</p>
     *
     * @return  The amount of this transaction line.
     */
    public Amount getAmount() {
        return this.amount;
    }

    /**
     * Sets the amount of money credited or debited by this transaction line.
     *
     * <p>By convention, positive amounts are debits and negative amounts are
     * credits.</p>
     *
     * @param   amount
     *          The new amount of this transaction line.
     */
    public void setAmount(final Amount amount) {
        this.ensureNotNull(amount, "amount");
        this.amount = amount;
    }

    /**
     * Gets the (optional) identifier for the document (i.e. journal entry ID)
     * that contains the transaction.
     *
     * <p>All transaction lines in the same transaction must share the same
     * document number.</p>
     *
     * @return  The document number for the transaction.
     */
    public DocNumber getDocNumber() {
        return docNumber;
    }

    /**
     * Sets the (optional) identifier for the document (i.e. journal entry ID)
     * that contains the transaction.
     *
     * <p>All transaction lines in the same transaction must share the same
     * document number.</p>
     *
     * @param   docNumber
     *          The new document number for the transaction.
     */
    public void setDocNumber(final DocNumber docNumber) {
        this.ensureNotNull(docNumber, "docNumber");
        this.docNumber = docNumber;
    }

    /**
     * Gets the (optional) memo / notes for this transaction line.
     *
     * @return  The memo for this transaction line.
     */
    public Memo getMemo() {
        return this.memo;
    }

    /**
     * Sets the (optional) memo / notes for this transaction line.
     *
     * @param   memo
     *          The new memo for this transaction line.
     */
    public void setMemo(final Memo memo) {
        this.ensureNotNull(memo, "memo");
        this.memo = memo;
    }

    /**
     * Gets QuickBooks' unique code for the type of this data line.
     *
     * TODO: Make this an enum instead?
     *
     * @return  Either "TRNS" or "SPL".
     */
    public abstract String getLineType();

    /**
     * Creates a shallow copy of this {@link DataLine}.
     *
     * @return  A new {@link DataLine}, having all of the same field values and
     *          references as this instance.
     */
    @Override
    public DataLine clone() {
        try {
            return (DataLine)super.clone();
        } catch (CloneNotSupportedException ex) {
            throw new RuntimeException(ex);
        }
    }

    /**
     * {@inheritDoc}
     *
     * <p>All of the columns of this line are exported into a tab-separated IIF
     * line.</p>
     *
     * @return  A representation of the data in this line, in IIF format.
     */
    @Override
    public String toIifString() {
        IifExportable[] columns = new IifExportable[] {
            this.getId(),
            this.getType(),
            this.getDate(),
            this.getAccount(),
            this.getName(),
            this.getTxnClass(),
            this.getAmount(),
            this.getDocNumber(),
            this.getMemo(),
        };

        return IifUtils.exportToString(
            new String[] { this.getLineType() },
            columns);
    }

    /**
     * Internal convenience method for argument checking.
     *
     * TODO: Move to a name-brand common library method for this instead.
     *
     * @param   value
     *          The value to ensure is not null.
     *
     * @param   name
     *          The name of the argument in code, for error messaging.
     */
    protected void ensureNotNull(Object value, String name) {
        if (value == null) {
            throw new IllegalArgumentException(name + " cannot be null.");
        }
    }
}