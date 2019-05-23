package br.com.gda.business.cartItem.info;

import java.util.List;

import br.com.gda.business.feeDefault.info.FeeDefaultInfo;
import br.com.gda.business.feeStore.info.FeetoreInfo;
import br.com.gda.business.masterData.info.CartCategInfo;
import br.com.gda.business.masterData.info.CurrencyInfo;
import br.com.gda.business.masterData.info.WeekdayInfo;
import br.com.gda.business.material.info.MatInfo;
import br.com.gda.business.store.info.StoreInfo;
import br.com.gda.business.totalAmount.info.TotAmountInfo;
import br.com.gda.business.user.info.UserInfo;
import br.com.gda.info.InfoMerger;
import br.com.gda.security.username.info.UsernameInfo;

public final class CartMerger {	
	public static CartInfo mergeWithCartCateg(CartCategInfo sourceOne, CartInfo sourceTwo) {
		InfoMerger<CartInfo, CartCategInfo> merger = new CartMergerCartCateg();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<CartInfo> mergeWithCartCateg(List<CartCategInfo> sourceOnes, List<CartInfo> sourceTwos) {
		InfoMerger<CartInfo, CartCategInfo> merger = new CartMergerCartCateg();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static CartInfo mergeWithCurrency(CurrencyInfo sourceOne, CartInfo sourceTwo) {
		InfoMerger<CartInfo, CurrencyInfo> merger = new CartMergerCurrency();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<CartInfo> mergeWithCurrency(List<CurrencyInfo> sourceOnes, List<CartInfo> sourceTwos) {
		InfoMerger<CartInfo, CurrencyInfo> merger = new CartMergerCurrency();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static CartInfo mergeWithFeeDefault(FeeDefaultInfo sourceOne, CartInfo sourceTwo) {
		InfoMerger<CartInfo, FeeDefaultInfo> merger = new CartMergerFeeDefault();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<CartInfo> mergeWithFeeDefault(List<FeeDefaultInfo> sourceOnes, List<CartInfo> sourceTwos) {
		InfoMerger<CartInfo, FeeDefaultInfo> merger = new CartMergerFeeDefault();		
		return merger.merge(sourceOnes, sourceTwos);
	}		
	
	
	
	public static CartInfo mergeWithFeetore(FeetoreInfo sourceOne, CartInfo sourceTwo) {
		InfoMerger<CartInfo, FeetoreInfo> merger = new CartMergerFeetore();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<CartInfo> mergeWithFeetore(List<FeetoreInfo> sourceOnes, List<CartInfo> sourceTwos) {
		InfoMerger<CartInfo, FeetoreInfo> merger = new CartMergerFeetore();		
		return merger.merge(sourceOnes, sourceTwos);
	}			
	
	
	
	public static CartInfo mergeWithMat(MatInfo sourceOne, CartInfo sourceTwo) {
		InfoMerger<CartInfo, MatInfo> merger = new CartMergerMat();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<CartInfo> mergeWithMat(List<MatInfo> sourceOnes, List<CartInfo> sourceTwos) {
		InfoMerger<CartInfo, MatInfo> merger = new CartMergerMat();		
		return merger.merge(sourceOnes, sourceTwos);
	}		
	
	
	
	public static CartInfo mergeWithStore(StoreInfo sourceOne, CartInfo sourceTwo) {
		InfoMerger<CartInfo, StoreInfo> merger = new CartMergerStore();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<CartInfo> mergeWithStore(List<StoreInfo> sourceOnes, List<CartInfo> sourceTwos) {
		InfoMerger<CartInfo, StoreInfo> merger = new CartMergerStore();		
		return merger.merge(sourceOnes, sourceTwos);
	}		
	
	
	
	public static CartInfo mergeWithTotAmount(TotAmountInfo sourceOne, CartInfo sourceTwo) {
		InfoMerger<CartInfo, TotAmountInfo> merger = new CartMergerTotAmount();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<CartInfo> mergeWithTotAmount(List<TotAmountInfo> sourceOnes, List<CartInfo> sourceTwos) {
		InfoMerger<CartInfo, TotAmountInfo> merger = new CartMergerTotAmount();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static CartInfo mergeWithUser(UserInfo sourceOne, CartInfo sourceTwo) {
		InfoMerger<CartInfo, UserInfo> merger = new CartMergerUser();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<CartInfo> mergeWithUser(List<UserInfo> sourceOnes, List<CartInfo> sourceTwos) {
		InfoMerger<CartInfo, UserInfo> merger = new CartMergerUser();		
		return merger.merge(sourceOnes, sourceTwos);
	}		
	
	
	
	public static CartInfo mergeWithUsername(UsernameInfo sourceOne, CartInfo sourceTwo) {
		InfoMerger<CartInfo, UsernameInfo> merger = new CartMergerUsername();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<CartInfo> mergeWithUsername(List<UsernameInfo> sourceOnes, List<CartInfo> sourceTwos) {
		InfoMerger<CartInfo, UsernameInfo> merger = new CartMergerUsername();		
		return merger.merge(sourceOnes, sourceTwos);
	}		
	
	
	
	public static CartInfo mergeWithWeekday(WeekdayInfo sourceOne, CartInfo sourceTwo) {
		InfoMerger<CartInfo, WeekdayInfo> merger = new CartMergerWeekday();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<CartInfo> mergeWithWeekday(List<WeekdayInfo> sourceOnes, List<CartInfo> sourceTwos) {
		InfoMerger<CartInfo, WeekdayInfo> merger = new CartMergerWeekday();		
		return merger.merge(sourceOnes, sourceTwos);
	}		
}
