package br.com.labexame.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Exame.class)
public abstract class Exame_ {

	public static volatile SingularAttribute<Exame, Long> id;
	public static volatile SingularAttribute<Exame, String> nome;
	public static volatile SingularAttribute<Exame, TipoExame> tipo;
	public static volatile SingularAttribute<Exame, Status> status;
	public static volatile ListAttribute<Exame, Laboratorio> laboratorios;

}
