package br.com.gda.business.amount.model.decisionTree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import br.com.gda.business.amount.info.AmountInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.decisionTree.DeciActionTransVisitor;

final class VisitorAmountTotal implements DeciActionTransVisitor<AmountInfo> {
	private long total;
	private int decimalPlace;
	//TODO: verificar soma entre moedas com diferentes casas decimais
	
	
	public VisitorAmountTotal() {
		total = 0;
		decimalPlace = 0;
	}
	
	
	
	@Override public List<AmountInfo> executeTransformation(List<AmountInfo> recordInfos) {
		List<AmountInfo> resultRecords = new ArrayList<>();	
		Iterator<AmountInfo> itr = recordInfos.iterator();
		
		if (itr.hasNext()) {
			AmountInfo eachRecord = itr.next();
			initializeTotal(eachRecord);
			
			while (itr.hasNext()) {
				eachRecord = itr.next();
				compute(eachRecord);
			}
		}
		
		
		resultRecords.add(getTotal());
		return resultRecords;
	}
	
	
	
	private void initializeTotal(AmountInfo recordInfo) {
		total = toLong(recordInfo);
		decimalPlace = recordInfo.decimalPlace;
	}
	
	
	
	private void compute(AmountInfo recordInfo) {
		checkDecimal(recordInfo);
		
		decimalPlace = recordInfo.decimalPlace;
		total = total + toLong(recordInfo);
	}
	
	
	
	private void checkDecimal(AmountInfo recordInfo) {		
		if (decimalPlace != recordInfo.decimalPlace)
			throw new IllegalArgumentException("decimalPlace" + SystemMessage.ARGUMENT_DONT_MATCH);
	}
	
	
	
	private long toLong(AmountInfo recordInfo) {
		return (long) (recordInfo.amount * (Math.pow(10, recordInfo.decimalPlace)));
	}
	
	
	
	private AmountInfo getTotal() {
		AmountInfo resultTotal = new AmountInfo();
		resultTotal.decimalPlace = decimalPlace;
		resultTotal.amount = total / (Math.pow(10, decimalPlace));
		
		return resultTotal;
	}
}
