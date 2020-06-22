package tho.nill.preislisten;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

public abstract class BasisServiceWithResult<DATEN,RETURNTYPE> {

	private PlatformTransactionManager transactionManager;

	public BasisServiceWithResult(PlatformTransactionManager transactionManager) {
		super();
		this.transactionManager = transactionManager;
	}

	public abstract RETURNTYPE performService(DATEN d);

	public RETURNTYPE service(DATEN d) {
		TransactionTemplate template = new TransactionTemplate(transactionManager);
		return template.execute(new TransactionCallback<RETURNTYPE>() {

			@Override
			public RETURNTYPE doInTransaction(TransactionStatus status) {
				return performService(d);
			}
		});

	}

}
