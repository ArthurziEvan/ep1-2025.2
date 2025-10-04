package src;
import java.io.*;
import java.util.*;

public class Persistencia {

    public static List<Paciente> lerPacientes(String caminho) {
        List<Paciente> lista = new ArrayList<>();
        File f = new File(caminho);
        if (!f.exists()) return lista;
        try (Scanner sc = new Scanner(f)) {
            while (sc.hasNextLine()) {
                String[] dados = sc.nextLine().split(";");
                if (dados.length == 4) {
                    lista.add(new Paciente(dados[0], dados[1], Integer.parseInt(dados[2]), dados[3]));
                }
            }
        } catch (Exception e) {
            System.out.println("Erro ao ler pacientes: " + e.getMessage());
        }
        return lista;
    }

    public static void salvarPacientes(String caminho, List<Paciente> pacientes) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(caminho))) {
            for (Paciente p : pacientes) {
                pw.println(p.getNome() + ";" + p.getCpf() + ";" + p.getIdade() + ";" + p.getTelefone());
            }
        } catch (Exception e) {
            System.out.println("Erro ao salvar pacientes: " + e.getMessage());
        }
    }

    public static List<Medico> lerMedicos(String caminho) {
        List<Medico> lista = new ArrayList<>();
        File f = new File(caminho);
        if (!f.exists()) return lista;
        try (Scanner sc = new Scanner(f)) {
            while (sc.hasNextLine()) {
                String[] dados = sc.nextLine().split(";");
                if (dados.length == 3) {
                    lista.add(new Medico(dados[0], dados[1], dados[2]));
                }
            }
        } catch (Exception e) {
            System.out.println("Erro ao ler médicos: " + e.getMessage());
        }
        return lista;
    }

    public static void salvarMedicos(String caminho, List<Medico> medicos) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(caminho))) {
            for (Medico m : medicos) {
                pw.println(m.getNome() + ";" + m.getCrm() + ";" + m.getEspecialidade());
            }
        } catch (Exception e) {
            System.out.println("Erro ao salvar médicos: " + e.getMessage());
        }
    }

    public static List<PlanoSaude> lerPlanos(String caminho) {
        List<PlanoSaude> lista = new ArrayList<>();
        File f = new File(caminho);
        if (!f.exists()) return lista;
        try (Scanner sc = new Scanner(f)) {
            while (sc.hasNextLine()) {
                String[] dados = sc.nextLine().split(";");
                if (dados.length == 3) {
                    lista.add(new PlanoSaude(dados[0], Double.parseDouble(dados[1]), Double.parseDouble(dados[2])));
                }
            }
        } catch (Exception e) {
            System.out.println("Erro ao ler planos: " + e.getMessage());
        }
        return lista;
    }

    public static void salvarPlanos(String caminho, List<PlanoSaude> planos) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(caminho))) {
            for (PlanoSaude p : planos) {
                pw.println(p.getNome() + ";" + p.getDescontoConsulta() + ";" + p.getDescontoInternacao());
            }
        } catch (Exception e) {
            System.out.println("Erro ao salvar planos: " + e.getMessage());
        }
    }
}