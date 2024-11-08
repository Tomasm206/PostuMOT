package co.edu.uco.postumot.common.bussineslogic.usecase;

public interface RuleWithOutFactory<T> {
	void execute(T data);
}

