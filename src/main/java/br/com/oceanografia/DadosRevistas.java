package br.com.oceanografia;

import java.util.ArrayList;
import java.util.List;

public class DadosRevistas {

    // MODELO DE UMA REVISTA

    public static class Revista {

        private final String nome;
        private final String categoria;
        private final String descricao;
        private final String acesso;
        private final String link;

        public Revista(
            String nome,
            String categoria,
            String descricao,
            String acesso,
            String link
        ) {
            this.nome = nome;
            this.categoria = categoria;
            this.descricao = descricao;
            this.acesso = acesso;
            this.link = link;
        }

        public String getNome() {
            return nome;
        }

        public String getCategoria() {
            return categoria;
        }

        public String getDescricao() {
            return descricao;
        }

        public String getAcesso() {
            return acesso;
        }

        public String getLink() {
            return link;
        }
    }


    // LISTA DE REVISTAS

    public static List<Revista> carregar() {

        List<Revista> revistas = new ArrayList<>();


        // OCEANOGRAFIA GERAL

        adicionar(
            revistas,
            "Ocean Science",
            "Oceanografia Geral",
            "Pesquisas sobre processos físicos, químicos, biológicos e biogeoquímicos dos oceanos.",
            "Acesso aberto",
            "https://www.ocean-science.net/"
        );

        adicionar(
            revistas,
            "Progress in Oceanography",
            "Oceanografia Geral",
            "Pesquisas e revisões sobre processos oceânicos e avanços em Oceanografia.",
            "Consultar condições de acesso",
            "https://www.sciencedirect.com/journal/progress-in-oceanography"
        );

        adicionar(
            revistas,
            "Ocean Modelling",
            "Oceanografia Física",
            "Modelagem numérica e computacional de processos oceânicos.",
            "Consultar condições de acesso",
            "https://www.sciencedirect.com/journal/ocean-modelling"
        );

        adicionar(
            revistas,
            "Deep-Sea Research Part I",
            "Oceanografia Geral",
            "Pesquisas oceanográficas relacionadas principalmente ao oceano profundo.",
            "Consultar condições de acesso",
            "https://www.sciencedirect.com/journal/deep-sea-research-part-i-oceanographic-research-papers"
        );

        adicionar(
            revistas,
            "Deep-Sea Research Part II",
            "Oceanografia Geral",
            "Estudos temáticos e coleções especiais relacionadas à Oceanografia.",
            "Consultar condições de acesso",
            "https://www.sciencedirect.com/journal/deep-sea-research-part-ii-topical-studies-in-oceanography"
        );

        adicionar(
            revistas,
            "Journal of Marine Systems",
            "Oceanografia Geral",
            "Estudos interdisciplinares sobre sistemas marinhos e processos oceânicos.",
            "Consultar condições de acesso",
            "https://www.sciencedirect.com/journal/journal-of-marine-systems"
        );

        adicionar(
            revistas,
            "Journal of Operational Oceanography",
            "Oceanografia Geral",
            "Oceanografia operacional, previsão oceânica, observação, clima e tecnologias oceânicas.",
            "Acesso híbrido",
            "https://www.tandfonline.com/journals/tjoo20"
        );

        adicionar(
            revistas,
            "Journal of Marine Science and Engineering",
            "Engenharia Oceânica",
            "Ciências do Mar, Oceanografia, engenharia oceânica e ambientes costeiros.",
            "Acesso aberto",
            "https://www.mdpi.com/journal/jmse"
        );

        adicionar(
            revistas,
            "Oceans",
            "Oceanografia Geral",
            "Pesquisa multidisciplinar sobre oceanos, recursos marinhos e sustentabilidade.",
            "Acesso aberto",
            "https://www.mdpi.com/journal/oceans"
        );

        adicionar(
            revistas,
            "Annual Review of Marine Science",
            "Oceanografia Geral",
            "Artigos de revisão sobre importantes avanços das Ciências do Mar.",
            "Consultar condições de acesso",
            "https://www.annualreviews.org/content/journals/marine"
        );


        // BRASIL

        adicionar(
            revistas,
            "Ocean and Coastal Research",
            "Brasil",
            "Periódico do Instituto Oceanográfico da USP dedicado às Ciências do Mar.",
            "Acesso aberto",
            "https://www.scielo.br/j/ocr/"
        );

        adicionar(
            revistas,
            "Brazilian Journal of Oceanography",
            "Brasil",
            "Acervo histórico do periódico que passou a se chamar Ocean and Coastal Research.",
            "Acervo histórico",
            "https://www.scielo.br/j/bjoce/"
        );


        // BIOLOGIA E ECOLOGIA MARINHA

        adicionar(
            revistas,
            "Marine Biology",
            "Biologia Marinha",
            "Pesquisas sobre organismos marinhos, ecologia, fisiologia e ecossistemas.",
            "Consultar condições de acesso",
            "https://link.springer.com/journal/227"
        );

        adicionar(
            revistas,
            "Marine Biology Research",
            "Biologia Marinha",
            "Biologia marinha, oceanografia biológica, biodiversidade, habitats e ecologia.",
            "Acesso híbrido",
            "https://www.tandfonline.com/journals/smar20"
        );

        adicionar(
            revistas,
            "Marine Ecology Progress Series",
            "Ecologia Marinha",
            "Pesquisas sobre organismos, populações, comunidades e ecossistemas marinhos.",
            "Consultar condições de acesso",
            "https://www.int-res.com/journals/meps/"
        );

        adicionar(
            revistas,
            "Marine Ecology",
            "Ecologia Marinha",
            "Ecologia de organismos, comunidades e habitats marinhos.",
            "Consultar condições de acesso",
            "https://onlinelibrary.wiley.com/journal/14390485"
        );

        adicionar(
            revistas,
            "Frontiers in Marine Science",
            "Biologia Marinha",
            "Pesquisa multidisciplinar sobre oceanos, biodiversidade, conservação e ecossistemas.",
            "Acesso aberto",
            "https://www.frontiersin.org/journals/marine-science"
        );

        adicionar(
            revistas,
            "Marine Biodiversity",
            "Biologia Marinha",
            "Estudos sobre biodiversidade, evolução e distribuição de organismos marinhos.",
            "Consultar condições de acesso",
            "https://link.springer.com/journal/12526"
        );

        adicionar(
            revistas,
            "Marine Biodiversity Records",
            "Biologia Marinha",
            "Registros científicos relacionados à biodiversidade e espécies marinhas.",
            "Acesso aberto",
            "https://marine-biodiversity-records.biomedcentral.com/"
        );

        adicionar(
            revistas,
            "Journal of Experimental Marine Biology and Ecology",
            "Biologia Marinha",
            "Pesquisa experimental sobre organismos e processos ecológicos marinhos.",
            "Consultar condições de acesso",
            "https://www.sciencedirect.com/journal/journal-of-experimental-marine-biology-and-ecology"
        );


        // OCEANOGRAFIA FÍSICA

        adicionar(
            revistas,
            "Journal of Physical Oceanography",
            "Oceanografia Física",
            "Correntes, ondas, circulação oceânica e interação entre oceano e atmosfera.",
            "Consultar condições de acesso",
            "https://journals.ametsoc.org/view/journals/phoc/phoc-overview.xml"
        );

        adicionar(
            revistas,
            "Journal of Geophysical Research: Oceans",
            "Oceanografia Física",
            "Processos físicos, químicos, biológicos e geológicos relacionados aos oceanos.",
            "Consultar condições de acesso",
            "https://agupubs.onlinelibrary.wiley.com/journal/21699291"
        );

        adicionar(
            revistas,
            "Ocean Dynamics",
            "Oceanografia Física",
            "Dinâmica oceânica, circulação, modelagem e processos físicos.",
            "Consultar condições de acesso",
            "https://link.springer.com/journal/10236"
        );

        adicionar(
            revistas,
            "Dynamics of Atmospheres and Oceans",
            "Oceanografia Física",
            "Dinâmica física e matemática dos oceanos e da atmosfera.",
            "Consultar condições de acesso",
            "https://www.sciencedirect.com/journal/dynamics-of-atmospheres-and-oceans"
        );

        adicionar(
            revistas,
            "Ocean Engineering",
            "Engenharia Oceânica",
            "Engenharia, estruturas, sistemas e tecnologias utilizadas no ambiente oceânico.",
            "Consultar condições de acesso",
            "https://www.sciencedirect.com/journal/ocean-engineering"
        );


        // GEOLOGIA, MAPEAMENTO E FUNDO OCEÂNICO

        adicionar(
            revistas,
            "Marine Geology",
            "Geologia Marinha",
            "Geologia dos oceanos, sedimentos, margens continentais e fundo marinho.",
            "Consultar condições de acesso",
            "https://www.sciencedirect.com/journal/marine-geology"
        );

        adicionar(
            revistas,
            "Marine Geophysical Research",
            "Geologia Marinha",
            "Geofísica marinha, estrutura da crosta e processos geológicos oceânicos.",
            "Consultar condições de acesso",
            "https://link.springer.com/journal/11001"
        );

        adicionar(
            revistas,
            "Marine Geodesy",
            "Geologia Marinha",
            "Mapeamento oceânico, batimetria, sensoriamento remoto, navegação e levantamentos marinhos.",
            "Acesso híbrido",
            "https://www.tandfonline.com/journals/umgd20"
        );

        adicionar(
            revistas,
            "Geo-Marine Letters",
            "Geologia Marinha",
            "Pesquisas sobre processos geológicos e sedimentares em ambientes marinhos.",
            "Consultar condições de acesso",
            "https://link.springer.com/journal/367"
        );


        // PESCA E RECURSOS MARINHOS

        adicionar(
            revistas,
            "ICES Journal of Marine Science",
            "Pesca e Recursos Marinhos",
            "Ciência marinha, ecossistemas, pesca e impactos das atividades humanas.",
            "Acesso aberto",
            "https://academic.oup.com/icesjms"
        );

        adicionar(
            revistas,
            "Fisheries Oceanography",
            "Pesca e Recursos Marinhos",
            "Relações entre processos oceânicos, ecossistemas e recursos pesqueiros.",
            "Consultar condições de acesso",
            "https://onlinelibrary.wiley.com/journal/13652419"
        );

        adicionar(
            revistas,
            "Fish and Fisheries",
            "Pesca e Recursos Marinhos",
            "Pesquisa e revisão científica sobre pesca, populações e conservação de peixes.",
            "Consultar condições de acesso",
            "https://onlinelibrary.wiley.com/journal/14672979"
        );

        adicionar(
            revistas,
            "Marine and Coastal Fisheries",
            "Pesca e Recursos Marinhos",
            "Ciência pesqueira, conservação e gestão de recursos marinhos e costeiros.",
            "Acesso aberto",
            "https://afspubs.onlinelibrary.wiley.com/journal/19425120"
        );


        // COSTA E ESTUÁRIOS

        adicionar(
            revistas,
            "Estuarine, Coastal and Shelf Science",
            "Ambientes Costeiros",
            "Estuários, regiões costeiras, plataforma continental e ecossistemas associados.",
            "Consultar condições de acesso",
            "https://www.sciencedirect.com/journal/estuarine-coastal-and-shelf-science"
        );

        adicionar(
            revistas,
            "Journal of Coastal Research",
            "Ambientes Costeiros",
            "Pesquisa científica sobre praias, costas, erosão e processos costeiros.",
            "Consultar condições de acesso",
            "https://meridian.allenpress.com/jcr"
        );

        adicionar(
            revistas,
            "Coastal Engineering",
            "Engenharia Costeira",
            "Ondas, estruturas costeiras, transporte de sedimentos e engenharia do litoral.",
            "Consultar condições de acesso",
            "https://www.sciencedirect.com/journal/coastal-engineering"
        );

        adicionar(
            revistas,
            "Ocean & Coastal Management",
            "Ambientes Costeiros",
            "Gestão, políticas públicas, conservação e utilização sustentável das zonas costeiras.",
            "Consultar condições de acesso",
            "https://www.sciencedirect.com/journal/ocean-and-coastal-management"
        );


        // POLUIÇÃO E CONSERVAÇÃO

        adicionar(
            revistas,
            "Marine Pollution Bulletin",
            "Poluição Marinha",
            "Poluição dos oceanos, contaminantes, lixo marinho e impactos ambientais.",
            "Consultar condições de acesso",
            "https://www.sciencedirect.com/journal/marine-pollution-bulletin"
        );

        adicionar(
            revistas,
            "Marine Environmental Research",
            "Conservação",
            "Impactos ambientais, ecotoxicologia e respostas de organismos e ecossistemas marinhos.",
            "Consultar condições de acesso",
            "https://www.sciencedirect.com/journal/marine-environmental-research"
        );

        adicionar(
            revistas,
            "Marine Policy",
            "Conservação",
            "Políticas oceânicas, governança, recursos marinhos e sustentabilidade.",
            "Consultar condições de acesso",
            "https://www.sciencedirect.com/journal/marine-policy"
        );

        adicionar(
            revistas,
            "Aquatic Conservation: Marine and Freshwater Ecosystems",
            "Conservação",
            "Conservação de ecossistemas, habitats e espécies aquáticas.",
            "Consultar condições de acesso",
            "https://onlinelibrary.wiley.com/journal/10990755"
        );


        // OBSERVAÇÃO E TECNOLOGIA

        adicionar(
            revistas,
            "Journal of Atmospheric and Oceanic Technology",
            "Tecnologia Oceânica",
            "Instrumentação, sensores, observação e tecnologias para atmosfera e oceanos.",
            "Consultar condições de acesso",
            "https://journals.ametsoc.org/view/journals/atot/atot-overview.xml"
        );

        adicionar(
            revistas,
            "IEEE Journal of Oceanic Engineering",
            "Tecnologia Oceânica",
            "Robótica submarina, sonar, sensores, comunicação e engenharia oceânica.",
            "Consultar condições de acesso",
            "https://ieeexplore.ieee.org/xpl/RecentIssue.jsp?punumber=48"
        );

        adicionar(
            revistas,
            "Oceanography",
            "Oceanografia Geral",
            "Artigos científicos e educacionais relacionados à Oceanografia e Ciências do Mar.",
            "Consultar condições de acesso",
            "https://tos.org/oceanography"
        );


        adicionar(
            revistas,
            "Continental Shelf Research",
            "Oceanografia Geral",
            "Pesquisas sobre processos físicos, químicos, biológicos e geológicos das plataformas continentais.",
            "Consultar condições de acesso",
            "https://www.sciencedirect.com/journal/continental-shelf-research"
        );

        adicionar(
            revistas,
            "Journal of Sea Research",
            "Oceanografia Geral",
            "Estudos sobre processos marinhos, ecologia, biologia e funcionamento dos ecossistemas oceânicos.",
            "Consultar condições de acesso",
            "https://www.sciencedirect.com/journal/journal-of-sea-research"
        );

        adicionar(
            revistas,
            "Oceanologia",
            "Oceanografia Geral",
            "Pesquisas multidisciplinares sobre ambientes marinhos, oceanografia e regiões costeiras.",
            "Consultar condições de acesso",
            "https://www.sciencedirect.com/journal/oceanologia"
        );

        adicionar(
            revistas,
            "Journal of Oceanography",
            "Oceanografia Geral",
            "Pesquisa sobre Oceanografia física, química, biológica e geológica.",
            "Consultar condições de acesso",
            "https://link.springer.com/journal/10872"
        );

        adicionar(
            revistas,
            "Ocean Science Journal",
            "Oceanografia Geral",
            "Estudos multidisciplinares relacionados aos oceanos e Ciências do Mar.",
            "Consultar condições de acesso",
            "https://link.springer.com/journal/12601"
        );

        adicionar(
            revistas,
            "Thalassas: An International Journal of Marine Sciences",
            "Oceanografia Geral",
            "Pesquisas multidisciplinares relacionadas às Ciências do Mar.",
            "Consultar condições de acesso",
            "https://link.springer.com/journal/41208"
        );

        adicionar(
            revistas,
            "Regional Studies in Marine Science",
            "Oceanografia Geral",
            "Estudos regionais sobre ambientes, processos e recursos marinhos.",
            "Consultar condições de acesso",
            "https://www.sciencedirect.com/journal/regional-studies-in-marine-science"
        );

        adicionar(
            revistas,
            "Journal of Marine Research",
            "Oceanografia Geral",
            "Pesquisas fundamentais sobre processos oceânicos e Ciências do Mar.",
            "Consultar condições de acesso",
            "https://elischolar.library.yale.edu/journal_of_marine_research/"
        );

        adicionar(
            revistas,
            "Acta Oceanologica Sinica",
            "Oceanografia Geral",
            "Pesquisas sobre diferentes áreas da Oceanografia e Ciências do Mar.",
            "Consultar condições de acesso",
            "https://link.springer.com/journal/13131"
        );

        adicionar(
            revistas,
            "Journal of Oceanology and Limnology",
            "Oceanografia Geral",
            "Pesquisas sobre oceanos, ambientes aquáticos e limnologia.",
            "Consultar condições de acesso",
            "https://link.springer.com/journal/343"
        );


        // ECOLOGIA, BIODIVERSIDADE E ORGANISMOS MARINHOS

        adicionar(
            revistas,
            "Coral Reefs",
            "Biologia Marinha",
            "Pesquisas sobre recifes de coral, organismos recifais e ecossistemas associados.",
            "Consultar condições de acesso",
            "https://link.springer.com/journal/338"
        );

        adicionar(
            revistas,
            "Bulletin of Marine Science",
            "Biologia Marinha",
            "Pesquisas sobre organismos, ambientes e processos relacionados às Ciências do Mar.",
            "Consultar condições de acesso",
            "https://www.ingentaconnect.com/content/umrsmas/bullmar"
        );

        adicionar(
            revistas,
            "Journal of the Marine Biological Association of the United Kingdom",
            "Biologia Marinha",
            "Pesquisas sobre organismos marinhos, biodiversidade e ecologia.",
            "Consultar condições de acesso",
            "https://www.cambridge.org/core/journals/journal-of-the-marine-biological-association-of-the-united-kingdom"
        );

        adicionar(
            revistas,
            "Scientia Marina",
            "Biologia Marinha",
            "Pesquisa em Ciências do Mar, incluindo ecologia, pesca e Oceanografia.",
            "Acesso aberto",
            "https://scientiamarina.revistas.csic.es/"
        );

        adicionar(
            revistas,
            "Mediterranean Marine Science",
            "Biologia Marinha",
            "Pesquisas sobre biodiversidade, ecologia e Oceanografia do Mediterrâneo e regiões relacionadas.",
            "Acesso aberto",
            "https://ejournals.epublishing.ekt.gr/index.php/hcmr-med-mar-sc"
        );

        adicionar(
            revistas,
            "Marine Genomics",
            "Biologia Marinha",
            "Genética, genômica e biologia molecular de organismos marinhos.",
            "Consultar condições de acesso",
            "https://www.sciencedirect.com/journal/marine-genomics"
        );

        adicionar(
            revistas,
            "Marine Biotechnology",
            "Biologia Marinha",
            "Biotecnologia baseada em organismos e recursos provenientes do ambiente marinho.",
            "Consultar condições de acesso",
            "https://link.springer.com/journal/10126"
        );

        adicionar(
            revistas,
            "Marine Drugs",
            "Biologia Marinha",
            "Pesquisa sobre compostos naturais, moléculas e substâncias provenientes de organismos marinhos.",
            "Acesso aberto",
            "https://www.mdpi.com/journal/marinedrugs"
        );

        adicionar(
            revistas,
            "Journal of Plankton Research",
            "Biologia Marinha",
            "Pesquisa sobre plâncton, ecologia planctônica e funcionamento dos ecossistemas aquáticos.",
            "Consultar condições de acesso",
            "https://academic.oup.com/plankt"
        );

        adicionar(
            revistas,
            "Plankton and Benthos Research",
            "Biologia Marinha",
            "Estudos científicos sobre organismos planctônicos e bentônicos.",
            "Acesso aberto",
            "https://www.jstage.jst.go.jp/browse/pbr"
        );

        adicionar(
            revistas,
            "Harmful Algae",
            "Biologia Marinha",
            "Pesquisa sobre algas nocivas, florações de algas e seus impactos ambientais.",
            "Consultar condições de acesso",
            "https://www.sciencedirect.com/journal/harmful-algae"
        );

        adicionar(
            revistas,
            "Journal of Phycology",
            "Biologia Marinha",
            "Pesquisa sobre algas, sua biologia, ecologia, evolução e fisiologia.",
            "Consultar condições de acesso",
            "https://onlinelibrary.wiley.com/journal/15298817"
        );

        adicionar(
            revistas,
            "Phycologia",
            "Biologia Marinha",
            "Estudos científicos sobre algas marinhas e de água doce.",
            "Consultar condições de acesso",
            "https://www.tandfonline.com/journals/uphy20"
        );

        adicionar(
            revistas,
            "Botanica Marina",
            "Biologia Marinha",
            "Pesquisa sobre algas, plantas marinhas e ecossistemas costeiros.",
            "Consultar condições de acesso",
            "https://www.degruyter.com/journal/key/botm/html"
        );


        // MAMÍFEROS E FAUNA MARINHA

        adicionar(
            revistas,
            "Marine Mammal Science",
            "Biologia Marinha",
            "Pesquisas científicas sobre baleias, golfinhos, focas e outros mamíferos marinhos.",
            "Consultar condições de acesso",
            "https://onlinelibrary.wiley.com/journal/17487692"
        );

        adicionar(
            revistas,
            "Aquatic Mammals",
            "Biologia Marinha",
            "Pesquisa científica sobre mamíferos aquáticos, comportamento, ecologia e conservação.",
            "Consultar condições de acesso",
            "https://www.aquaticmammalsjournal.org/"
        );

        adicionar(
            revistas,
            "Marine Ornithology",
            "Biologia Marinha",
            "Pesquisa sobre aves marinhas, distribuição, ecologia e conservação.",
            "Acesso aberto",
            "https://marineornithology.org/"
        );


        // PESCA E AQUICULTURA

        adicionar(
            revistas,
            "Fisheries Research",
            "Pesca e Recursos Marinhos",
            "Pesquisa científica relacionada à pesca, estoques pesqueiros e gestão de recursos.",
            "Consultar condições de acesso",
            "https://www.sciencedirect.com/journal/fisheries-research"
        );

        adicionar(
            revistas,
            "Reviews in Fish Biology and Fisheries",
            "Pesca e Recursos Marinhos",
            "Revisões sobre biologia, ecologia, conservação e gestão de peixes.",
            "Consultar condições de acesso",
            "https://link.springer.com/journal/11160"
        );

        adicionar(
            revistas,
            "Fishery Bulletin",
            "Pesca e Recursos Marinhos",
            "Pesquisas científicas sobre recursos pesqueiros e ecossistemas marinhos.",
            "Acesso aberto",
            "https://spo.nmfs.noaa.gov/content/fishery-bulletin"
        );

        adicionar(
            revistas,
            "Marine Fisheries Review",
            "Pesca e Recursos Marinhos",
            "Informações científicas e técnicas sobre pesca e recursos marinhos.",
            "Acesso aberto",
            "https://spo.nmfs.noaa.gov/content/marine-fisheries-review"
        );

        adicionar(
            revistas,
            "Aquaculture",
            "Pesca e Recursos Marinhos",
            "Pesquisa científica sobre criação de organismos aquáticos e sistemas de aquicultura.",
            "Consultar condições de acesso",
            "https://www.sciencedirect.com/journal/aquaculture"
        );

        adicionar(
            revistas,
            "Aquaculture Reports",
            "Pesca e Recursos Marinhos",
            "Pesquisa aplicada sobre aquicultura, produção e sustentabilidade.",
            "Acesso aberto",
            "https://www.sciencedirect.com/journal/aquaculture-reports"
        );

        adicionar(
            revistas,
            "Aquaculture Environment Interactions",
            "Pesca e Recursos Marinhos",
            "Interações ambientais relacionadas à aquicultura e aos ecossistemas aquáticos.",
            "Acesso aberto",
            "https://www.int-res.com/journals/aei/"
        );

        adicionar(
            revistas,
            "Journal of Shellfish Research",
            "Pesca e Recursos Marinhos",
            "Pesquisa sobre moluscos, crustáceos, cultivo, ecologia e recursos pesqueiros.",
            "Consultar condições de acesso",
            "https://bioone.org/journals/journal-of-shellfish-research"
        );


        // CONSERVAÇÃO E IMPACTOS AMBIENTAIS

        adicionar(
            revistas,
            "Endangered Species Research",
            "Conservação",
            "Pesquisa sobre espécies ameaçadas, conservação e impactos ambientais.",
            "Acesso aberto",
            "https://www.int-res.com/journals/esr/"
        );

        adicionar(
            revistas,
            "Diseases of Aquatic Organisms",
            "Conservação",
            "Pesquisa sobre doenças e agentes patogênicos de organismos aquáticos.",
            "Consultar condições de acesso",
            "https://www.int-res.com/journals/dao/"
        );

        adicionar(
            revistas,
            "Estuaries and Coasts",
            "Ambientes Costeiros",
            "Pesquisa sobre estuários, zonas costeiras e interação entre sistemas terrestres e marinhos.",
            "Consultar condições de acesso",
            "https://link.springer.com/journal/12237"
        );

        adicionar(
            revistas,
            "Journal of Coastal Conservation",
            "Conservação",
            "Gestão, planejamento e conservação de ambientes costeiros.",
            "Consultar condições de acesso",
            "https://link.springer.com/journal/11852"
        );

        adicionar(
            revistas,
            "Coastal Management",
            "Ambientes Costeiros",
            "Pesquisa sobre planejamento, políticas e gestão sustentável das zonas costeiras.",
            "Consultar condições de acesso",
            "https://www.tandfonline.com/journals/ucmg20"
        );


        // GEOLOGIA E PALEOCEANOGRAFIA

        adicionar(
            revistas,
            "Marine Micropaleontology",
            "Geologia Marinha",
            "Micropaleontologia marinha e reconstrução de ambientes oceânicos do passado.",
            "Consultar condições de acesso",
            "https://www.sciencedirect.com/journal/marine-micropaleontology"
        );

        adicionar(
            revistas,
            "Paleoceanography and Paleoclimatology",
            "Geologia Marinha",
            "Reconstrução e estudo das mudanças dos oceanos e do clima ao longo do tempo geológico.",
            "Consultar condições de acesso",
            "https://agupubs.onlinelibrary.wiley.com/journal/25724525"
        );


        // ENGENHARIA E TECNOLOGIA OCEÂNICA

        adicionar(
            revistas,
            "Applied Ocean Research",
            "Engenharia Oceânica",
            "Aplicações de engenharia, modelagem e tecnologias voltadas ao ambiente oceânico.",
            "Consultar condições de acesso",
            "https://www.sciencedirect.com/journal/applied-ocean-research"
        );

        adicionar(
            revistas,
            "Marine Structures",
            "Engenharia Oceânica",
            "Pesquisa sobre estruturas offshore, navios e sistemas de engenharia marinha.",
            "Consultar condições de acesso",
            "https://www.sciencedirect.com/journal/marine-structures"
        );

        adicionar(
            revistas,
            "Journal of Marine Science and Technology",
            "Engenharia Oceânica",
            "Tecnologias marítimas, navios, estruturas e engenharia oceânica.",
            "Consultar condições de acesso",
            "https://link.springer.com/journal/773"
        );

        adicionar(
            revistas,
            "International Journal of Naval Architecture and Ocean Engineering",
            "Engenharia Oceânica",
            "Arquitetura naval, hidrodinâmica e engenharia oceânica.",
            "Acesso aberto",
            "https://www.sciencedirect.com/journal/international-journal-of-naval-architecture-and-ocean-engineering"
        );

        adicionar(
            revistas,
            "Journal of Ocean Engineering and Science",
            "Engenharia Oceânica",
            "Pesquisa científica e tecnológica em engenharia oceânica.",
            "Consultar condições de acesso",
            "https://www.sciencedirect.com/journal/journal-of-ocean-engineering-and-science"
        );

        adicionar(
            revistas,
            "Coastal Engineering Journal",
            "Engenharia Costeira",
            "Engenharia costeira, ondas, estruturas e dinâmica sedimentar.",
            "Consultar condições de acesso",
            "https://www.tandfonline.com/journals/tcej20"
        );

        adicionar(
            revistas,
            "Journal of Waterway, Port, Coastal, and Ocean Engineering",
            "Engenharia Costeira",
            "Engenharia portuária, costeira, marítima e oceânica.",
            "Consultar condições de acesso",
            "https://ascelibrary.org/journal/jwped5"
        );


        // QUÍMICA E BIOGEOQUÍMICA DOS OCEANOS

        adicionar(
            revistas,
            "Marine Chemistry",
            "Oceanografia Química",
            "Processos químicos e biogeoquímicos que ocorrem nos oceanos.",
            "Consultar condições de acesso",
            "https://www.sciencedirect.com/journal/marine-chemistry"
        );

        adicionar(
            revistas,
            "Biogeosciences",
            "Oceanografia Química",
            "Interações entre processos biológicos, químicos, físicos e geológicos do sistema terrestre.",
            "Acesso aberto",
            "https://www.biogeosciences.net/"
        );

        adicionar(
            revistas,
            "Global Biogeochemical Cycles",
            "Oceanografia Química",
            "Ciclos biogeoquímicos globais e interações entre oceanos, atmosfera e continentes.",
            "Consultar condições de acesso",
            "https://agupubs.onlinelibrary.wiley.com/journal/19449224"
        );


        // CLIMA E INTERAÇÃO OCEANO-ATMOSFERA

        adicionar(
            revistas,
            "Journal of Climate",
            "Clima e Oceanos",
            "Pesquisa sobre clima, variabilidade climática e interações entre oceano e atmosfera.",
            "Consultar condições de acesso",
            "https://journals.ametsoc.org/view/journals/clim/clim-overview.xml"
        );

        adicionar(
            revistas,
            "Climate Dynamics",
            "Clima e Oceanos",
            "Pesquisa sobre dinâmica climática, oceanos e interação oceano-atmosfera.",
            "Consultar condições de acesso",
            "https://link.springer.com/journal/382"
        );

        adicionar(
            revistas,
            "Geophysical Research Letters",
            "Clima e Oceanos",
            "Pesquisas de rápida comunicação em geociências, incluindo Oceanografia e clima.",
            "Consultar condições de acesso",
            "https://agupubs.onlinelibrary.wiley.com/journal/19448007"
        );


        // REVISTAS INTERNACIONAIS E REGIONAIS

        adicionar(
            revistas,
            "New Zealand Journal of Marine and Freshwater Research",
            "Biologia Marinha",
            "Pesquisa sobre ecossistemas marinhos e de água doce.",
            "Consultar condições de acesso",
            "https://www.tandfonline.com/journals/tnzm20"
        );

        adicionar(
            revistas,
            "African Journal of Marine Science",
            "Oceanografia Geral",
            "Pesquisa sobre ambientes marinhos africanos, pesca, ecologia e Oceanografia.",
            "Consultar condições de acesso",
            "https://www.tandfonline.com/journals/tams20"
        );

        adicionar(
            revistas,
            "Latin American Journal of Aquatic Research",
            "Oceanografia Geral",
            "Pesquisa latino-americana sobre Ciências Aquáticas, Oceanografia e recursos marinhos.",
            "Acesso aberto",
            "https://www.lajar.cl/"
        );

        adicionar(
            revistas,
            "Revista de Biología Marina y Oceanografía",
            "Biologia Marinha",
            "Pesquisa latino-americana sobre biologia marinha e Oceanografia.",
            "Acesso aberto",
            "https://revistas.uv.cl/index.php/rbmo"
        );

        adicionar(
            revistas,
            "Ciencias Marinas",
            "Oceanografia Geral",
            "Pesquisa científica sobre Oceanografia e ambientes costeiros e marinhos.",
            "Acesso aberto",
            "https://cienciasmarinas.com.mx/"
        );

        adicionar(
            revistas,
            "Ocean and Polar Research",
            "Oceanografia Geral",
            "Pesquisa sobre Oceanografia, ambientes polares e Ciências do Mar.",
            "Acesso aberto",
            "https://koreascience.kr/journal/HOGBB1.page"
        );

        adicionar(
            revistas,
            "Polar Biology",
            "Biologia Marinha",
            "Pesquisa sobre organismos e ecossistemas das regiões polares.",
            "Consultar condições de acesso",
            "https://link.springer.com/journal/300"
        );

        adicionar(
            revistas,
            "Polar Research",
            "Oceanografia Geral",
            "Pesquisa interdisciplinar sobre regiões Ártica e Antártica.",
            "Acesso aberto",
            "https://polarresearch.net/"
        );

        adicionar(
            revistas,
            "Antarctic Science",
            "Oceanografia Geral",
            "Pesquisa científica multidisciplinar sobre a Antártica e o Oceano Austral.",
            "Consultar condições de acesso",
            "https://www.cambridge.org/core/journals/antarctic-science"
        );

        return revistas;
    }


    // MÉTODO AUXILIAR

    private static void adicionar(
        List<Revista> lista,
        String nome,
        String categoria,
        String descricao,
        String acesso,
        String link
    ) {

        lista.add(
            new Revista(
                nome,
                categoria,
                descricao,
                acesso,
                link
            )
        );
    }
}