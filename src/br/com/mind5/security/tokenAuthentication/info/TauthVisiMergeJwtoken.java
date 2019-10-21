package br.com.mind5.security.tokenAuthentication.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.security.jwtToken.info.JwtokenInfo;

final class TauthVisiMergeJwtoken implements InfoMergerVisitor<TauthInfo, JwtokenInfo> {

	@Override public TauthInfo writeRecord(JwtokenInfo sourceOne, TauthInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		TauthInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(JwtokenInfo sourceOne, TauthInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private TauthInfo makeClone(TauthInfo recordInfo) {
		try {
			return (TauthInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private TauthInfo merge(JwtokenInfo sourceOne, TauthInfo sourceTwo) {
		sourceTwo.codOwner = sourceOne.codOwner;
		sourceTwo.username = sourceOne.username;
		sourceTwo.codPlatform = sourceOne.codPlatform;
		
		return sourceTwo;
	}


	
	@Override public boolean shouldWrite(JwtokenInfo sourceOne, TauthInfo sourceTwo) {
		if (sourceOne == null ||
			sourceTwo == null		)
			return false;
		
		return true;
	}		
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
