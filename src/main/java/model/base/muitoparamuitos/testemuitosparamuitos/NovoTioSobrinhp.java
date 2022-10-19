package model.base.muitoparamuitos.testemuitosparamuitos;

import infra.DAO;
import model.base.muitoparamuitos.Sobrinho;
import model.base.muitoparamuitos.Tio;

public class NovoTioSobrinhp {
    public static void main(String[] args) {

        Tio tio1= new Tio("Maria");
        Tio tio2= new Tio("Pedro");

        Sobrinho sobrinho1 = new Sobrinho("Gabriel");
        Sobrinho sobrinho2 = new Sobrinho("Ana");

        tio1.getSobrinhos().add(sobrinho1);
        sobrinho1.getTios().add(tio1);

        tio1.getSobrinhos().add(sobrinho2);
        sobrinho2.getTios().add(tio1);

        tio2.getSobrinhos().add(sobrinho1);
        sobrinho1.getTios().add(tio2);

        tio2.getSobrinhos().add(sobrinho2);
        sobrinho2.getTios().add(tio2);

        DAO<Object> dao = new DAO<>();
        dao.abrirTransacao()
                .incluir(tio1)
                .incluir(tio2)
                .incluir(sobrinho1)
                .incluir(sobrinho2)
                .fecharTransacao()
                .fechar();




    }
}
