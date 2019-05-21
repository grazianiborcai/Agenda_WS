package br.com.gda.business.cartSnapshot.model.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.cartSnapshot.info.CartSnapInfo;
import br.com.gda.business.masterData.info.common.CartFlag;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.action.ActionMultiVisitorTemplate;

final class VisiCartSnapJoinResult extends ActionMultiVisitorTemplate<CartSnapInfo> {
	private List<CartSnapInfo> fees;
	private List<CartSnapInfo> totals;
	private List<CartSnapInfo> items;
	
	
	public VisiCartSnapJoinResult() {
		super();
	}
	
	
	
	@Override protected boolean buildListHook(List<CartSnapInfo> infoRecords, boolean hasNext) {
		boolean token = super.NOT_TAKEN;
		
		if (token == super.NOT_TAKEN)
			token = buildFees(infoRecords);
		
		if (token == super.NOT_TAKEN)
			token = buildTotals(infoRecords);
		
		if (token == super.NOT_TAKEN)
			token = buildItems(infoRecords);
		
		return token;
	}
	
	
	
	private boolean buildFees(List<CartSnapInfo> infoRecords) {
		if (isFee(infoRecords) == super.NOT_FLAGGED)
			return super.NOT_TAKEN;
		
		initFees();
		buildListFees(infoRecords);
		
		return super.IS_TAKEN;
	}
	
	
	
	private boolean isFee(List<CartSnapInfo> infoRecords) {
		for (CartSnapInfo eachRecord: infoRecords) {
			if (eachRecord.recordFlag != CartFlag.FEE.getFlagId())
				return super.NOT_FLAGGED;
		}
		
		return super.FLAGGED;
	}
	
	
	
	private void initFees() {
		fees = new ArrayList<>();
	}
	
	
	
	private void buildListFees(List<CartSnapInfo> infoRecords) {
		fees.addAll(infoRecords);
	}
	
	
	
	private boolean buildTotals(List<CartSnapInfo> infoRecords) {
		if (isTotal(infoRecords) == super.NOT_FLAGGED)
			return super.NOT_TAKEN;
		
		initTotals();
		buildListTotals(infoRecords);
		
		return super.IS_TAKEN;
	}
	
	
	
	private boolean isTotal(List<CartSnapInfo> infoRecords) {
		for (CartSnapInfo eachRecord: infoRecords) {
			if (eachRecord.recordFlag != CartFlag.TOTAL.getFlagId())
				return super.NOT_FLAGGED;
		}
		
		return super.FLAGGED;
	}
	
	
	
	private void initTotals() {
		totals = new ArrayList<>();
	}
	
	
	
	private void buildListTotals(List<CartSnapInfo> infoRecords) {
		totals.addAll(infoRecords);
	}
	
	
	
	private boolean buildItems(List<CartSnapInfo> infoRecords) {
		if (isItem(infoRecords) == super.NOT_FLAGGED)
			return super.NOT_TAKEN;
		
		initItems();
		buildListItems(infoRecords);
		
		return super.IS_TAKEN;
	}
	
	
	
	private boolean isItem(List<CartSnapInfo> infoRecords) {
		for (CartSnapInfo eachRecord: infoRecords) {
			if (eachRecord.recordFlag != CartFlag.ITEM.getFlagId())
				return super.NOT_FLAGGED;
		}
		
		return super.FLAGGED;
	}
	
	
	
	private void initItems() {
		items = new ArrayList<>();
	}
	
	
	
	private void buildListItems(List<CartSnapInfo> infoRecords) {
		items.addAll(infoRecords);
	}
	
	
	
	@Override protected List<CartSnapInfo> executeHook() {
		return joinResult();
	}
	
	
	
	private List<CartSnapInfo> joinResult() {
		checkList();
		return join();
	}
	
	
	
	private void checkList() {
		if (items == null || items.isEmpty()) {
			logException(new IllegalStateException("items" + SystemMessage.ACTION_NOT_INIT));
			throw new IllegalStateException("items" + SystemMessage.ACTION_NOT_INIT);
		}
		
		
		if (fees == null || fees.isEmpty()) {
			logException(new IllegalStateException("fees" + SystemMessage.ACTION_NOT_INIT));
			throw new IllegalStateException("fees" + SystemMessage.ACTION_NOT_INIT);
		}
		
		
		if (totals == null || totals.isEmpty()) {
			logException(new IllegalStateException("totals" + SystemMessage.ACTION_NOT_INIT));
			throw new IllegalStateException("totals" + SystemMessage.ACTION_NOT_INIT);
		}
	}
	
	
	
	private List<CartSnapInfo> join() {
		List<CartSnapInfo> results = new ArrayList<>();
		
		for (CartSnapInfo eachItem : items) {
			CartSnapInfo cloned = makeClone(eachItem);
			results.add(cloned);
		}		
		
		
		for (CartSnapInfo eachItem : fees) {
			CartSnapInfo cloned = makeClone(eachItem);
			results.add(cloned);
		}	
		
		
		for (CartSnapInfo eachItem : totals) {
			CartSnapInfo cloned = makeClone(eachItem);
			results.add(cloned);
		}	
		
		
		return results;
	}
	
	
	
	private CartSnapInfo makeClone(CartSnapInfo recordInfo) {
		try {
			return (CartSnapInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
