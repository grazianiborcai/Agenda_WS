package br.com.gda.business.totalAmount.model.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import br.com.gda.business.totalAmount.info.TotAmountInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.action.ActionVisitorEnforce;

final class VisiTotAmountTwo implements ActionVisitorEnforce<TotAmountInfo> {
	private long total;
	private int decimalPlace;
	//TODO: verificar soma entre moedas com diferentes casas decimais
	
	
	public VisiTotAmountTwo() {
		total = 0;
		decimalPlace = 0;
	}
	
	
	
	@Override public List<TotAmountInfo> executeTransformation(List<TotAmountInfo> recordInfos) {
		List<TotAmountInfo> resultRecords = new ArrayList<>();	
		Iterator<TotAmountInfo> itr = recordInfos.iterator();
		
		if (itr.hasNext()) {
			TotAmountInfo eachRecord = itr.next();
			initializeTotal(eachRecord);
			
			while (itr.hasNext()) {
				eachRecord = itr.next();
				compute(eachRecord);
			}
		}
		
		
		resultRecords.add(getTotal());
		return resultRecords;
	}
	
	
	
	private void initializeTotal(TotAmountInfo recordInfo) {
		total = toLong(recordInfo);
		decimalPlace = recordInfo.decimalPlace;
	}
	
	
	
	private void compute(TotAmountInfo recordInfo) {
		checkDecimal(recordInfo);
		
		decimalPlace = recordInfo.decimalPlace;
		total = total + toLong(recordInfo);
	}
	
	
	
	private void checkDecimal(TotAmountInfo recordInfo) {		
		if (decimalPlace != recordInfo.decimalPlace)
			throw new IllegalArgumentException("decimalPlace" + SystemMessage.ARGUMENT_DONT_MATCH);
	}
	
	
	
	private long toLong(TotAmountInfo recordInfo) {
		return (long) (recordInfo.amount * (Math.pow(10, recordInfo.decimalPlace)));
	}
	
	
	
	private TotAmountInfo getTotal() {
		TotAmountInfo resultTotal = new TotAmountInfo();
		resultTotal.decimalPlace = decimalPlace;
		resultTotal.amount = total / (Math.pow(10, decimalPlace));
		
		return resultTotal;
	}
}
