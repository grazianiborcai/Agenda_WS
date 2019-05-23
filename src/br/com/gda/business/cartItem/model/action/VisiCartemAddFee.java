package br.com.gda.business.cartItem.model.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.cartItem.info.CartemInfo;
import br.com.gda.business.masterData.info.common.CartFlag;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.action.ActionMultiVisitorTemplate;

final class VisiCartemAddFee extends ActionMultiVisitorTemplate<CartemInfo> {
	private CartemInfo fee;
	private List<CartemInfo> items;
	
	
	public VisiCartemAddFee() {
		super();
	}
	
	
	
	@Override protected boolean buildListHook(List<CartemInfo> infoRecords, boolean hasNext) {
		boolean token = super.NOT_TAKEN;
		
		if (token == super.NOT_TAKEN)
			token = buildFee(infoRecords);
		
		if (token == super.NOT_TAKEN)
			token = buildItems(infoRecords);
		
		return token;
	}
	
	
	
	private boolean buildFee(List<CartemInfo> infoRecords) {
		if (isFee(infoRecords) == super.NOT_FLAGGED)
			return super.NOT_TAKEN;
		
		initFee();
		buildRecordFee(infoRecords);
		
		return super.IS_TAKEN;
	}
	
	
	
	private boolean isFee(List<CartemInfo> infoRecords) {
		for (CartemInfo eachRecord: infoRecords) {
			if (eachRecord.recordFlag != CartFlag.FEE.getFlagId())
				return super.NOT_FLAGGED;
		}
		
		return super.FLAGGED;
	}
	
	
	
	private void initFee() {
		fee = null;
	}
	
	
	
	private void buildRecordFee(List<CartemInfo> infoRecords) {
		CartemInfo firstRow = infoRecords.get(0);
		fee = firstRow;
	}
	
	
	
	private boolean buildItems(List<CartemInfo> infoRecords) {
		if (isItem(infoRecords) == super.NOT_FLAGGED)
			return super.NOT_TAKEN;
		
		initItems();
		buildListItems(infoRecords);
		
		return super.IS_TAKEN;
	}
	
	
	
	private boolean isItem(List<CartemInfo> infoRecords) {
		for (CartemInfo eachRecord: infoRecords) {
			if (eachRecord.recordFlag != CartFlag.ITEM.getFlagId())
				return super.NOT_FLAGGED;
		}
		
		return super.FLAGGED;
	}
	
	
	
	private void initItems() {
		items = new ArrayList<>();
	}
	
	
	
	private void buildListItems(List<CartemInfo> infoRecords) {
		items.addAll(infoRecords);
	}
	
	
	
	@Override protected List<CartemInfo> executeHook() {
		return addFeeToItems();
	}
	
	
	
	private List<CartemInfo> addFeeToItems() {
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
	
	
	
	private List<CartemInfo> add() {
		List<CartemInfo> results = new ArrayList<>();
		
		for (CartemInfo eachItem : items) {
			CartemInfo cloned = makeClone(eachItem);
			results.add(cloned);
		}		
		
		CartemInfo cloned = makeClone(fee);
		results.add(cloned);
		
		return results;
	}
	
	
	
	private CartemInfo makeClone(CartemInfo recordInfo) {
		try {
			return (CartemInfo) recordInfo.clone();
			
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
