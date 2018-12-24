package br.com.gda.business.cart.model.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.cart.info.CartFlag;
import br.com.gda.business.cart.info.CartInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.action.ActionMultiVisitorTemplate;

final class VisiCartAddFee extends ActionMultiVisitorTemplate<CartInfo> {
	private CartInfo fee;
	private List<CartInfo> items;
	
	
	public VisiCartAddFee() {
		super();
	}
	
	
	
	@Override protected boolean buildListHook(List<CartInfo> infoRecords, boolean hasNext) {
		boolean token = super.NOT_TAKEN;
		
		if (token == super.NOT_TAKEN)
			token = buildFee(infoRecords);
		
		if (token == super.NOT_TAKEN)
			token = buildItems(infoRecords);
		
		return token;
	}
	
	
	
	private boolean buildFee(List<CartInfo> infoRecords) {
		if (isFee(infoRecords) == super.NOT_FLAGGED)
			return super.NOT_TAKEN;
		
		initFee();
		buildRecordFee(infoRecords);
		
		return super.IS_TAKEN;
	}
	
	
	
	private boolean isFee(List<CartInfo> infoRecords) {
		for (CartInfo eachRecord: infoRecords) {
			if (eachRecord.recordFlag != CartFlag.FEE.getFlagId())
				return super.NOT_FLAGGED;
		}
		
		return super.FLAGGED;
	}
	
	
	
	private void initFee() {
		fee = null;
	}
	
	
	
	private void buildRecordFee(List<CartInfo> infoRecords) {
		CartInfo firstRow = infoRecords.get(0);
		fee = firstRow;
	}
	
	
	
	private boolean buildItems(List<CartInfo> infoRecords) {
		if (isItem(infoRecords) == super.NOT_FLAGGED)
			return super.NOT_TAKEN;
		
		initItems();
		buildListItems(infoRecords);
		
		return super.IS_TAKEN;
	}
	
	
	
	private boolean isItem(List<CartInfo> infoRecords) {
		for (CartInfo eachRecord: infoRecords) {
			if (eachRecord.recordFlag != CartFlag.ITEM.getFlagId())
				return super.NOT_FLAGGED;
		}
		
		return super.FLAGGED;
	}
	
	
	
	private void initItems() {
		items = new ArrayList<>();
	}
	
	
	
	private void buildListItems(List<CartInfo> infoRecords) {
		items.addAll(infoRecords);
	}
	
	
	
	@Override protected List<CartInfo> executeHook() {
		return addFeeToItems();
	}
	
	
	
	private List<CartInfo> addFeeToItems() {
		checkList();
		return add();
	}
	
	
	
	private void checkList() {
		if (items == null || items.isEmpty()) {
			logException(new IllegalStateException("items" + SystemMessage.ACTION_NOT_INIT));
			throw new IllegalStateException("items" + SystemMessage.ACTION_NOT_INIT);
		}
		
		if (fee == null) {
			logException(new IllegalStateException("fee" + SystemMessage.ACTION_NOT_INIT));
			throw new IllegalStateException("fee" + SystemMessage.ACTION_NOT_INIT);
		}
	}
	
	
	
	private List<CartInfo> add() {
		List<CartInfo> results = new ArrayList<>();
		
		for (CartInfo eachItem : items) {
			CartInfo cloned = makeClone(eachItem);
			results.add(cloned);
		}		
		
		CartInfo cloned = makeClone(fee);
		results.add(cloned);
		
		return results;
	}
	
	
	
	private CartInfo makeClone(CartInfo recordInfo) {
		try {
			return (CartInfo) recordInfo.clone();
			
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
