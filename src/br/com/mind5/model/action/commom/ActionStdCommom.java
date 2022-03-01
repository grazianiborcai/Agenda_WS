package br.com.mind5.model.action.commom;

import java.lang.reflect.Constructor;

import br.com.mind5.info.InfoRecord;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class ActionStdCommom<T extends InfoRecord> extends ActionStdTemplate<T> {
	
	public ActionStdCommom(DeciTreeOption<T> option, Class<? extends ActionVisitor<T>> actionVisitorClazz) {
		super(option, actionVisitorClazz);
	}
	
	
	
	@Override protected ActionVisitor<T> buildVisitorHook(DeciTreeOption<T> option, Class<? extends ActionVisitor<T>> actionVisitorClazz) {
		return buildActionVisitor(option, actionVisitorClazz);
	}
	
	
	
	private ActionVisitor<T> buildActionVisitor(DeciTreeOption<T> option, Class<? extends ActionVisitor<T>> actionVisitorClazz) {
		try {
			Constructor<? extends ActionVisitor<T>> actionConstru = actionVisitorClazz.getConstructor(new Class[]{DeciTreeOption.class});
			return (ActionVisitor<T>) actionConstru.newInstance(option);
				
			} catch (Exception e) {
				super.logException(e);
				throw new IllegalArgumentException(e);
			}
	}
}
