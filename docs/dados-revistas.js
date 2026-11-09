// DADOS DAS REVISTAS CIENTÍFICAS - OCEANO HUB
// Convertido de DadosRevistas.java

const dadosRevistas = [

    // OCEANOGRAFIA GERAL

    {
        nome: "Ocean Science",
        categoria: "Oceanografia Geral",
        descricao: "Pesquisas sobre processos físicos, químicos, biológicos e biogeoquímicos dos oceanos.",
        acesso: "Acesso aberto",
        link: "https://www.ocean-science.net/"
    },

    {
        nome: "Progress in Oceanography",
        categoria: "Oceanografia Geral",
        descricao: "Pesquisas e revisões sobre processos oceânicos e avanços em Oceanografia.",
        acesso: "Consultar condições de acesso",
        link: "https://www.sciencedirect.com/journal/progress-in-oceanography"
    },

    {
        nome: "Ocean Modelling",
        categoria: "Oceanografia Física",
        descricao: "Modelagem numérica e computacional de processos oceânicos.",
        acesso: "Consultar condições de acesso",
        link: "https://www.sciencedirect.com/journal/ocean-modelling"
    },

    {
        nome: "Deep-Sea Research Part I",
        categoria: "Oceanografia Geral",
        descricao: "Pesquisas oceanográficas relacionadas principalmente ao oceano profundo.",
        acesso: "Consultar condições de acesso",
        link: "https://www.sciencedirect.com/journal/deep-sea-research-part-i-oceanographic-research-papers"
    },

    {
        nome: "Deep-Sea Research Part II",
        categoria: "Oceanografia Geral",
        descricao: "Estudos temáticos e coleções especiais relacionadas à Oceanografia.",
        acesso: "Consultar condições de acesso",
        link: "https://www.sciencedirect.com/journal/deep-sea-research-part-ii-topical-studies-in-oceanography"
    },

    {
        nome: "Journal of Marine Systems",
        categoria: "Oceanografia Geral",
        descricao: "Estudos interdisciplinares sobre sistemas marinhos e processos oceânicos.",
        acesso: "Consultar condições de acesso",
        link: "https://www.sciencedirect.com/journal/journal-of-marine-systems"
    },

    {
        nome: "Journal of Operational Oceanography",
        categoria: "Oceanografia Geral",
        descricao: "Oceanografia operacional, previsão oceânica, observação, clima e tecnologias oceânicas.",
        acesso: "Acesso híbrido",
        link: "https://www.tandfonline.com/journals/tjoo20"
    },

    {
        nome: "Journal of Marine Science and Engineering",
        categoria: "Engenharia Oceânica",
        descricao: "Ciências do Mar, Oceanografia, engenharia oceânica e ambientes costeiros.",
        acesso: "Acesso aberto",
        link: "https://www.mdpi.com/journal/jmse"
    },

    {
        nome: "Oceans",
        categoria: "Oceanografia Geral",
        descricao: "Pesquisa multidisciplinar sobre oceanos, recursos marinhos e sustentabilidade.",
        acesso: "Acesso aberto",
        link: "https://www.mdpi.com/journal/oceans"
    },

    {
        nome: "Annual Review of Marine Science",
        categoria: "Oceanografia Geral",
        descricao: "Artigos de revisão sobre importantes avanços das Ciências do Mar.",
        acesso: "Consultar condições de acesso",
        link: "https://www.annualreviews.org/content/journals/marine"
    },


    // BRASIL

    {
        nome: "Ocean and Coastal Research",
        categoria: "Brasil",
        descricao: "Periódico do Instituto Oceanográfico da USP dedicado às Ciências do Mar.",
        acesso: "Acesso aberto",
        link: "https://www.scielo.br/j/ocr/"
    },

    {
        nome: "Brazilian Journal of Oceanography",
        categoria: "Brasil",
        descricao: "Acervo histórico do periódico que passou a se chamar Ocean and Coastal Research.",
        acesso: "Acervo histórico",
        link: "https://www.scielo.br/j/bjoce/"
    },


    // BIOLOGIA E ECOLOGIA MARINHA

    {
        nome: "Marine Biology",
        categoria: "Biologia Marinha",
        descricao: "Pesquisas sobre organismos marinhos, ecologia, fisiologia e ecossistemas.",
        acesso: "Consultar condições de acesso",
        link: "https://link.springer.com/journal/227"
    },

    {
        nome: "Marine Biology Research",
        categoria: "Biologia Marinha",
        descricao: "Biologia marinha, oceanografia biológica, biodiversidade, habitats e ecologia.",
        acesso: "Acesso híbrido",
        link: "https://www.tandfonline.com/journals/smar20"
    },

    {
        nome: "Marine Ecology Progress Series",
        categoria: "Ecologia Marinha",
        descricao: "Pesquisas sobre organismos, populações, comunidades e ecossistemas marinhos.",
        acesso: "Consultar condições de acesso",
        link: "https://www.int-res.com/journals/meps/"
    },

    {
        nome: "Marine Ecology",
        categoria: "Ecologia Marinha",
        descricao: "Ecologia de organismos, comunidades e habitats marinhos.",
        acesso: "Consultar condições de acesso",
        link: "https://onlinelibrary.wiley.com/journal/14390485"
    },

    {
        nome: "Frontiers in Marine Science",
        categoria: "Biologia Marinha",
        descricao: "Pesquisa multidisciplinar sobre oceanos, biodiversidade, conservação e ecossistemas.",
        acesso: "Acesso aberto",
        link: "https://www.frontiersin.org/journals/marine-science"
    },

    {
        nome: "Marine Biodiversity",
        categoria: "Biologia Marinha",
        descricao: "Estudos sobre biodiversidade, evolução e distribuição de organismos marinhos.",
        acesso: "Consultar condições de acesso",
        link: "https://link.springer.com/journal/12526"
    },

    {
        nome: "Marine Biodiversity Records",
        categoria: "Biologia Marinha",
        descricao: "Registros científicos relacionados à biodiversidade e espécies marinhas.",
        acesso: "Acesso aberto",
        link: "https://marine-biodiversity-records.biomedcentral.com/"
    },

    {
        nome: "Journal of Experimental Marine Biology and Ecology",
        categoria: "Biologia Marinha",
        descricao: "Pesquisa experimental sobre organismos e processos ecológicos marinhos.",
        acesso: "Consultar condições de acesso",
        link: "https://www.sciencedirect.com/journal/journal-of-experimental-marine-biology-and-ecology"
    },
    // OCEANOGRAFIA FÍSICA

    {
        nome: "Journal of Physical Oceanography",
        categoria: "Oceanografia Física",
        descricao: "Correntes, ondas, circulação oceânica e interação entre oceano e atmosfera.",
        acesso: "Consultar condições de acesso",
        link: "https://journals.ametsoc.org/view/journals/phoc/phoc-overview.xml"
    },

    {
        nome: "Journal of Geophysical Research: Oceans",
        categoria: "Oceanografia Física",
        descricao: "Processos físicos, químicos, biológicos e geológicos relacionados aos oceanos.",
        acesso: "Consultar condições de acesso",
        link: "https://agupubs.onlinelibrary.wiley.com/journal/21699291"
    },

    {
        nome: "Ocean Dynamics",
        categoria: "Oceanografia Física",
        descricao: "Dinâmica oceânica, circulação, modelagem e processos físicos.",
        acesso: "Consultar condições de acesso",
        link: "https://link.springer.com/journal/10236"
    },

    {
        nome: "Dynamics of Atmospheres and Oceans",
        categoria: "Oceanografia Física",
        descricao: "Dinâmica física e matemática dos oceanos e da atmosfera.",
        acesso: "Consultar condições de acesso",
        link: "https://www.sciencedirect.com/journal/dynamics-of-atmospheres-and-oceans"
    },

    {
        nome: "Ocean Engineering",
        categoria: "Engenharia Oceânica",
        descricao: "Engenharia, estruturas, sistemas e tecnologias utilizadas no ambiente oceânico.",
        acesso: "Consultar condições de acesso",
        link: "https://www.sciencedirect.com/journal/ocean-engineering"
    },


    // GEOLOGIA, MAPEAMENTO E FUNDO OCEÂNICO

    {
        nome: "Marine Geology",
        categoria: "Geologia Marinha",
        descricao: "Geologia dos oceanos, sedimentos, margens continentais e fundo marinho.",
        acesso: "Consultar condições de acesso",
        link: "https://www.sciencedirect.com/journal/marine-geology"
    },

    {
        nome: "Marine Geophysical Research",
        categoria: "Geologia Marinha",
        descricao: "Geofísica marinha, estrutura da crosta e processos geológicos oceânicos.",
        acesso: "Consultar condições de acesso",
        link: "https://link.springer.com/journal/11001"
    },

    {
        nome: "Marine Geodesy",
        categoria: "Geologia Marinha",
        descricao: "Mapeamento oceânico, batimetria, sensoriamento remoto, navegação e levantamentos marinhos.",
        acesso: "Acesso híbrido",
        link: "https://www.tandfonline.com/journals/umgd20"
    },

    {
        nome: "Geo-Marine Letters",
        categoria: "Geologia Marinha",
        descricao: "Pesquisas sobre processos geológicos e sedimentares em ambientes marinhos.",
        acesso: "Consultar condições de acesso",
        link: "https://link.springer.com/journal/367"
    },


    // PESCA E RECURSOS MARINHOS

    {
        nome: "ICES Journal of Marine Science",
        categoria: "Pesca e Recursos Marinhos",
        descricao: "Ciência marinha, ecossistemas, pesca e impactos das atividades humanas.",
        acesso: "Acesso aberto",
        link: "https://academic.oup.com/icesjms"
    },

    {
        nome: "Fisheries Oceanography",
        categoria: "Pesca e Recursos Marinhos",
        descricao: "Relações entre processos oceânicos, ecossistemas e recursos pesqueiros.",
        acesso: "Consultar condições de acesso",
        link: "https://onlinelibrary.wiley.com/journal/13652419"
    },

    {
        nome: "Fish and Fisheries",
        categoria: "Pesca e Recursos Marinhos",
        descricao: "Pesquisa e revisão científica sobre pesca, populações e conservação de peixes.",
        acesso: "Consultar condições de acesso",
        link: "https://onlinelibrary.wiley.com/journal/14672979"
    },

    {
        nome: "Marine and Coastal Fisheries",
        categoria: "Pesca e Recursos Marinhos",
        descricao: "Ciência pesqueira, conservação e gestão de recursos marinhos e costeiros.",
        acesso: "Acesso aberto",
        link: "https://afspubs.onlinelibrary.wiley.com/journal/19425120"
    },


    // COSTA E ESTUÁRIOS

    {
        nome: "Estuarine, Coastal and Shelf Science",
        categoria: "Ambientes Costeiros",
        descricao: "Estuários, regiões costeiras, plataforma continental e ecossistemas associados.",
        acesso: "Consultar condições de acesso",
        link: "https://www.sciencedirect.com/journal/estuarine-coastal-and-shelf-science"
    },

    {
        nome: "Journal of Coastal Research",
        categoria: "Ambientes Costeiros",
        descricao: "Pesquisa científica sobre praias, costas, erosão e processos costeiros.",
        acesso: "Consultar condições de acesso",
        link: "https://meridian.allenpress.com/jcr"
    },

    {
        nome: "Coastal Engineering",
        categoria: "Engenharia Costeira",
        descricao: "Ondas, estruturas costeiras, transporte de sedimentos e engenharia do litoral.",
        acesso: "Consultar condições de acesso",
        link: "https://www.sciencedirect.com/journal/coastal-engineering"
    },

    {
        nome: "Ocean & Coastal Management",
        categoria: "Ambientes Costeiros",
        descricao: "Gestão, políticas públicas, conservação e utilização sustentável das zonas costeiras.",
        acesso: "Consultar condições de acesso",
        link: "https://www.sciencedirect.com/journal/ocean-and-coastal-management"
    },


    // POLUIÇÃO E CONSERVAÇÃO

    {
        nome: "Marine Pollution Bulletin",
        categoria: "Poluição Marinha",
        descricao: "Poluição dos oceanos, contaminantes, lixo marinho e impactos ambientais.",
        acesso: "Consultar condições de acesso",
        link: "https://www.sciencedirect.com/journal/marine-pollution-bulletin"
    },

    {
        nome: "Marine Environmental Research",
        categoria: "Conservação",
        descricao: "Impactos ambientais, ecotoxicologia e respostas de organismos e ecossistemas marinhos.",
        acesso: "Consultar condições de acesso",
        link: "https://www.sciencedirect.com/journal/marine-environmental-research"
    },

    {
        nome: "Marine Policy",
        categoria: "Conservação",
        descricao: "Políticas oceânicas, governança, recursos marinhos e sustentabilidade.",
        acesso: "Consultar condições de acesso",
        link: "https://www.sciencedirect.com/journal/marine-policy"
    },

    {
        nome: "Aquatic Conservation: Marine and Freshwater Ecosystems",
        categoria: "Conservação",
        descricao: "Conservação de ecossistemas, habitats e espécies aquáticas.",
        acesso: "Consultar condições de acesso",
        link: "https://onlinelibrary.wiley.com/journal/10990755"
    },


    // OBSERVAÇÃO E TECNOLOGIA

    {
        nome: "Journal of Atmospheric and Oceanic Technology",
        categoria: "Tecnologia Oceânica",
        descricao: "Instrumentação, sensores, observação e tecnologias para atmosfera e oceanos.",
        acesso: "Consultar condições de acesso",
        link: "https://journals.ametsoc.org/view/journals/atot/atot-overview.xml"
    },

    {
        nome: "IEEE Journal of Oceanic Engineering",
        categoria: "Tecnologia Oceânica",
        descricao: "Robótica submarina, sonar, sensores, comunicação e engenharia oceânica.",
        acesso: "Consultar condições de acesso",
        link: "https://ieeexplore.ieee.org/xpl/RecentIssue.jsp?punumber=48"
    },

    {
        nome: "Oceanography",
        categoria: "Oceanografia Geral",
        descricao: "Artigos científicos e educacionais relacionados à Oceanografia e Ciências do Mar.",
        acesso: "Consultar condições de acesso",
        link: "https://tos.org/oceanography"
    },
    // OCEANOGRAFIA GERAL - CONTINUAÇÃO

    {
        nome: "Continental Shelf Research",
        categoria: "Oceanografia Geral",
        descricao: "Pesquisas sobre processos físicos, químicos, biológicos e geológicos das plataformas continentais.",
        acesso: "Consultar condições de acesso",
        link: "https://www.sciencedirect.com/journal/continental-shelf-research"
    },

    {
        nome: "Journal of Sea Research",
        categoria: "Oceanografia Geral",
        descricao: "Estudos sobre processos marinhos, ecologia, biologia e funcionamento dos ecossistemas oceânicos.",
        acesso: "Consultar condições de acesso",
        link: "https://www.sciencedirect.com/journal/journal-of-sea-research"
    },

    {
        nome: "Oceanologia",
        categoria: "Oceanografia Geral",
        descricao: "Pesquisas multidisciplinares sobre ambientes marinhos, oceanografia e regiões costeiras.",
        acesso: "Consultar condições de acesso",
        link: "https://www.sciencedirect.com/journal/oceanologia"
    },

    {
        nome: "Journal of Oceanography",
        categoria: "Oceanografia Geral",
        descricao: "Pesquisa sobre Oceanografia física, química, biológica e geológica.",
        acesso: "Consultar condições de acesso",
        link: "https://link.springer.com/journal/10872"
    },

    {
        nome: "Ocean Science Journal",
        categoria: "Oceanografia Geral",
        descricao: "Estudos multidisciplinares relacionados aos oceanos e Ciências do Mar.",
        acesso: "Consultar condições de acesso",
        link: "https://link.springer.com/journal/12601"
    },

    {
        nome: "Thalassas: An International Journal of Marine Sciences",
        categoria: "Oceanografia Geral",
        descricao: "Pesquisas multidisciplinares relacionadas às Ciências do Mar.",
        acesso: "Consultar condições de acesso",
        link: "https://link.springer.com/journal/41208"
    },

    {
        nome: "Regional Studies in Marine Science",
        categoria: "Oceanografia Geral",
        descricao: "Estudos regionais sobre ambientes, processos e recursos marinhos.",
        acesso: "Consultar condições de acesso",
        link: "https://www.sciencedirect.com/journal/regional-studies-in-marine-science"
    },

    {
        nome: "Journal of Marine Research",
        categoria: "Oceanografia Geral",
        descricao: "Pesquisas fundamentais sobre processos oceânicos e Ciências do Mar.",
        acesso: "Consultar condições de acesso",
        link: "https://elischolar.library.yale.edu/journal_of_marine_research/"
    },

    {
        nome: "Acta Oceanologica Sinica",
        categoria: "Oceanografia Geral",
        descricao: "Pesquisas sobre diferentes áreas da Oceanografia e Ciências do Mar.",
        acesso: "Consultar condições de acesso",
        link: "https://link.springer.com/journal/13131"
    },

    {
        nome: "Journal of Oceanology and Limnology",
        categoria: "Oceanografia Geral",
        descricao: "Pesquisas sobre oceanos, ambientes aquáticos e limnologia.",
        acesso: "Consultar condições de acesso",
        link: "https://link.springer.com/journal/343"
    },


    // ECOLOGIA, BIODIVERSIDADE E ORGANISMOS MARINHOS

    {
        nome: "Coral Reefs",
        categoria: "Biologia Marinha",
        descricao: "Pesquisas sobre recifes de coral, organismos recifais e ecossistemas associados.",
        acesso: "Consultar condições de acesso",
        link: "https://link.springer.com/journal/338"
    },

    {
        nome: "Bulletin of Marine Science",
        categoria: "Biologia Marinha",
        descricao: "Pesquisas sobre organismos, ambientes e processos relacionados às Ciências do Mar.",
        acesso: "Consultar condições de acesso",
        link: "https://www.ingentaconnect.com/content/umrsmas/bullmar"
    },

    {
        nome: "Journal of the Marine Biological Association of the United Kingdom",
        categoria: "Biologia Marinha",
        descricao: "Pesquisas sobre organismos marinhos, biodiversidade e ecologia.",
        acesso: "Consultar condições de acesso",
        link: "https://www.cambridge.org/core/journals/journal-of-the-marine-biological-association-of-the-united-kingdom"
    },

    {
        nome: "Scientia Marina",
        categoria: "Biologia Marinha",
        descricao: "Pesquisa em Ciências do Mar, incluindo ecologia, pesca e Oceanografia.",
        acesso: "Acesso aberto",
        link: "https://scientiamarina.revistas.csic.es/"
    },

    {
        nome: "Mediterranean Marine Science",
        categoria: "Biologia Marinha",
        descricao: "Pesquisas sobre biodiversidade, ecologia e Oceanografia do Mediterrâneo e regiões relacionadas.",
        acesso: "Acesso aberto",
        link: "https://ejournals.epublishing.ekt.gr/index.php/hcmr-med-mar-sc"
    },

    {
        nome: "Marine Genomics",
        categoria: "Biologia Marinha",
        descricao: "Genética, genômica e biologia molecular de organismos marinhos.",
        acesso: "Consultar condições de acesso",
        link: "https://www.sciencedirect.com/journal/marine-genomics"
    },

    {
        nome: "Marine Biotechnology",
        categoria: "Biologia Marinha",
        descricao: "Biotecnologia baseada em organismos e recursos provenientes do ambiente marinho.",
        acesso: "Consultar condições de acesso",
        link: "https://link.springer.com/journal/10126"
    },

    {
        nome: "Marine Drugs",
        categoria: "Biologia Marinha",
        descricao: "Pesquisa sobre compostos naturais, moléculas e substâncias provenientes de organismos marinhos.",
        acesso: "Acesso aberto",
        link: "https://www.mdpi.com/journal/marinedrugs"
    },

    {
        nome: "Journal of Plankton Research",
        categoria: "Biologia Marinha",
        descricao: "Pesquisa sobre plâncton, ecologia planctônica e funcionamento dos ecossistemas aquáticos.",
        acesso: "Consultar condições de acesso",
        link: "https://academic.oup.com/plankt"
    },

    {
        nome: "Plankton and Benthos Research",
        categoria: "Biologia Marinha",
        descricao: "Estudos científicos sobre organismos planctônicos e bentônicos.",
        acesso: "Acesso aberto",
        link: "https://www.jstage.jst.go.jp/browse/pbr"
    },

    {
        nome: "Harmful Algae",
        categoria: "Biologia Marinha",
        descricao: "Pesquisa sobre algas nocivas, florações de algas e seus impactos ambientais.",
        acesso: "Consultar condições de acesso",
        link: "https://www.sciencedirect.com/journal/harmful-algae"
    },

    {
        nome: "Journal of Phycology",
        categoria: "Biologia Marinha",
        descricao: "Pesquisa sobre algas, sua biologia, ecologia, evolução e fisiologia.",
        acesso: "Consultar condições de acesso",
        link: "https://onlinelibrary.wiley.com/journal/15298817"
    },

    {
        nome: "Phycologia",
        categoria: "Biologia Marinha",
        descricao: "Estudos científicos sobre algas marinhas e de água doce.",
        acesso: "Consultar condições de acesso",
        link: "https://www.tandfonline.com/journals/uphy20"
    },

    {
        nome: "Botanica Marina",
        categoria: "Biologia Marinha",
        descricao: "Pesquisa sobre algas, plantas marinhas e ecossistemas costeiros.",
        acesso: "Consultar condições de acesso",
        link: "https://www.degruyter.com/journal/key/botm/html"
    },


    // MAMÍFEROS E FAUNA MARINHA

    {
        nome: "Marine Mammal Science",
        categoria: "Biologia Marinha",
        descricao: "Pesquisas científicas sobre baleias, golfinhos, focas e outros mamíferos marinhos.",
        acesso: "Consultar condições de acesso",
        link: "https://onlinelibrary.wiley.com/journal/17487692"
    },

    {
        nome: "Aquatic Mammals",
        categoria: "Biologia Marinha",
        descricao: "Pesquisa científica sobre mamíferos aquáticos, comportamento, ecologia e conservação.",
        acesso: "Consultar condições de acesso",
        link: "https://www.aquaticmammalsjournal.org/"
    },

    {
        nome: "Marine Ornithology",
        categoria: "Biologia Marinha",
        descricao: "Pesquisa sobre aves marinhas, distribuição, ecologia e conservação.",
        acesso: "Acesso aberto",
        link: "https://marineornithology.org/"
    },


    // PESCA E AQUICULTURA

    {
        nome: "Fisheries Research",
        categoria: "Pesca e Recursos Marinhos",
        descricao: "Pesquisa científica relacionada à pesca, estoques pesqueiros e gestão de recursos.",
        acesso: "Consultar condições de acesso",
        link: "https://www.sciencedirect.com/journal/fisheries-research"
    },

    {
        nome: "Reviews in Fish Biology and Fisheries",
        categoria: "Pesca e Recursos Marinhos",
        descricao: "Revisões sobre biologia, ecologia, conservação e gestão de peixes.",
        acesso: "Consultar condições de acesso",
        link: "https://link.springer.com/journal/11160"
    },

    {
        nome: "Fishery Bulletin",
        categoria: "Pesca e Recursos Marinhos",
        descricao: "Pesquisas científicas sobre recursos pesqueiros e ecossistemas marinhos.",
        acesso: "Acesso aberto",
        link: "https://spo.nmfs.noaa.gov/content/fishery-bulletin"
    },

    {
        nome: "Marine Fisheries Review",
        categoria: "Pesca e Recursos Marinhos",
        descricao: "Informações científicas e técnicas sobre pesca e recursos marinhos.",
        acesso: "Acesso aberto",
        link: "https://spo.nmfs.noaa.gov/content/marine-fisheries-review"
    },

    {
        nome: "Aquaculture",
        categoria: "Pesca e Recursos Marinhos",
        descricao: "Pesquisa científica sobre criação de organismos aquáticos e sistemas de aquicultura.",
        acesso: "Consultar condições de acesso",
        link: "https://www.sciencedirect.com/journal/aquaculture"
    },

    {
        nome: "Aquaculture Reports",
        categoria: "Pesca e Recursos Marinhos",
        descricao: "Pesquisa aplicada sobre aquicultura, produção e sustentabilidade.",
        acesso: "Acesso aberto",
        link: "https://www.sciencedirect.com/journal/aquaculture-reports"
    },

    {
        nome: "Aquaculture Environment Interactions",
        categoria: "Pesca e Recursos Marinhos",
        descricao: "Interações ambientais relacionadas à aquicultura e aos ecossistemas aquáticos.",
        acesso: "Acesso aberto",
        link: "https://www.int-res.com/journals/aei/"
    },

    {
        nome: "Journal of Shellfish Research",
        categoria: "Pesca e Recursos Marinhos",
        descricao: "Pesquisa sobre moluscos, crustáceos, cultivo, ecologia e recursos pesqueiros.",
        acesso: "Consultar condições de acesso",
        link: "https://bioone.org/journals/journal-of-shellfish-research"
    },


    // CONSERVAÇÃO E IMPACTOS AMBIENTAIS

    {
        nome: "Endangered Species Research",
        categoria: "Conservação",
        descricao: "Pesquisa sobre espécies ameaçadas, conservação e impactos ambientais.",
        acesso: "Acesso aberto",
        link: "https://www.int-res.com/journals/esr/"
    },

    {
        nome: "Diseases of Aquatic Organisms",
        categoria: "Conservação",
        descricao: "Pesquisa sobre doenças e agentes patogênicos de organismos aquáticos.",
        acesso: "Consultar condições de acesso",
        link: "https://www.int-res.com/journals/dao/"
    },

    {
        nome: "Estuaries and Coasts",
        categoria: "Ambientes Costeiros",
        descricao: "Pesquisa sobre estuários, zonas costeiras e interação entre sistemas terrestres e marinhos.",
        acesso: "Consultar condições de acesso",
        link: "https://link.springer.com/journal/12237"
    },

    {
        nome: "Journal of Coastal Conservation",
        categoria: "Conservação",
        descricao: "Gestão, planejamento e conservação de ambientes costeiros.",
        acesso: "Consultar condições de acesso",
        link: "https://link.springer.com/journal/11852"
    },

    {
        nome: "Coastal Management",
        categoria: "Ambientes Costeiros",
        descricao: "Pesquisa sobre planejamento, políticas e gestão sustentável das zonas costeiras.",
        acesso: "Consultar condições de acesso",
        link: "https://www.tandfonline.com/journals/ucmg20"
    },


    // GEOLOGIA E PALEOCEANOGRAFIA

    {
        nome: "Marine Micropaleontology",
        categoria: "Geologia Marinha",
        descricao: "Micropaleontologia marinha e reconstrução de ambientes oceânicos do passado.",
        acesso: "Consultar condições de acesso",
        link: "https://www.sciencedirect.com/journal/marine-micropaleontology"
    },

    {
        nome: "Paleoceanography and Paleoclimatology",
        categoria: "Geologia Marinha",
        descricao: "Reconstrução e estudo das mudanças dos oceanos e do clima ao longo do tempo geológico.",
        acesso: "Consultar condições de acesso",
        link: "https://agupubs.onlinelibrary.wiley.com/journal/25724525"
    },


    // ENGENHARIA E TECNOLOGIA OCEÂNICA

    {
        nome: "Applied Ocean Research",
        categoria: "Engenharia Oceânica",
        descricao: "Aplicações de engenharia, modelagem e tecnologias voltadas ao ambiente oceânico.",
        acesso: "Consultar condições de acesso",
        link: "https://www.sciencedirect.com/journal/applied-ocean-research"
    },

    {
        nome: "Marine Structures",
        categoria: "Engenharia Oceânica",
        descricao: "Pesquisa sobre estruturas offshore, navios e sistemas de engenharia marinha.",
        acesso: "Consultar condições de acesso",
        link: "https://www.sciencedirect.com/journal/marine-structures"
    },

    {
        nome: "Journal of Marine Science and Technology",
        categoria: "Engenharia Oceânica",
        descricao: "Tecnologias marítimas, navios, estruturas e engenharia oceânica.",
        acesso: "Consultar condições de acesso",
        link: "https://link.springer.com/journal/773"
    },

    {
        nome: "International Journal of Naval Architecture and Ocean Engineering",
        categoria: "Engenharia Oceânica",
        descricao: "Arquitetura naval, hidrodinâmica e engenharia oceânica.",
        acesso: "Acesso aberto",
        link: "https://www.sciencedirect.com/journal/international-journal-of-naval-architecture-and-ocean-engineering"
    },

    {
        nome: "Journal of Ocean Engineering and Science",
        categoria: "Engenharia Oceânica",
        descricao: "Pesquisa científica e tecnológica em engenharia oceânica.",
        acesso: "Consultar condições de acesso",
        link: "https://www.sciencedirect.com/journal/journal-of-ocean-engineering-and-science"
    },

    {
        nome: "Coastal Engineering Journal",
        categoria: "Engenharia Costeira",
        descricao: "Engenharia costeira, ondas, estruturas e dinâmica sedimentar.",
        acesso: "Consultar condições de acesso",
        link: "https://www.tandfonline.com/journals/tcej20"
    },

    {
        nome: "Journal of Waterway, Port, Coastal, and Ocean Engineering",
        categoria: "Engenharia Costeira",
        descricao: "Engenharia portuária, costeira, marítima e oceânica.",
        acesso: "Consultar condições de acesso",
        link: "https://ascelibrary.org/journal/jwped5"
    },


    // QUÍMICA E BIOGEOQUÍMICA DOS OCEANOS

    {
        nome: "Marine Chemistry",
        categoria: "Oceanografia Química",
        descricao: "Processos químicos e biogeoquímicos que ocorrem nos oceanos.",
        acesso: "Consultar condições de acesso",
        link: "https://www.sciencedirect.com/journal/marine-chemistry"
    },

    {
        nome: "Biogeosciences",
        categoria: "Oceanografia Química",
        descricao: "Interações entre processos biológicos, químicos, físicos e geológicos do sistema terrestre.",
        acesso: "Acesso aberto",
        link: "https://www.biogeosciences.net/"
    },

    {
        nome: "Global Biogeochemical Cycles",
        categoria: "Oceanografia Química",
        descricao: "Ciclos biogeoquímicos globais e interações entre oceanos, atmosfera e continentes.",
        acesso: "Consultar condições de acesso",
        link: "https://agupubs.onlinelibrary.wiley.com/journal/19449224"
    },


    // CLIMA E INTERAÇÃO OCEANO-ATMOSFERA

    {
        nome: "Journal of Climate",
        categoria: "Clima e Oceanos",
        descricao: "Pesquisa sobre clima, variabilidade climática e interações entre oceano e atmosfera.",
        acesso: "Consultar condições de acesso",
        link: "https://journals.ametsoc.org/view/journals/clim/clim-overview.xml"
    },

    {
        nome: "Climate Dynamics",
        categoria: "Clima e Oceanos",
        descricao: "Pesquisa sobre dinâmica climática, oceanos e interação oceano-atmosfera.",
        acesso: "Consultar condições de acesso",
        link: "https://link.springer.com/journal/382"
    },

    {
        nome: "Geophysical Research Letters",
        categoria: "Clima e Oceanos",
        descricao: "Pesquisas de rápida comunicação em geociências, incluindo Oceanografia e clima.",
        acesso: "Consultar condições de acesso",
        link: "https://agupubs.onlinelibrary.wiley.com/journal/19448007"
    },


    // REVISTAS INTERNACIONAIS E REGIONAIS

    {
        nome: "New Zealand Journal of Marine and Freshwater Research",
        categoria: "Biologia Marinha",
        descricao: "Pesquisa sobre ecossistemas marinhos e de água doce.",
        acesso: "Consultar condições de acesso",
        link: "https://www.tandfonline.com/journals/tnzm20"
    },

    {
        nome: "African Journal of Marine Science",
        categoria: "Oceanografia Geral",
        descricao: "Pesquisa sobre ambientes marinhos africanos, pesca, ecologia e Oceanografia.",
        acesso: "Consultar condições de acesso",
        link: "https://www.tandfonline.com/journals/tams20"
    },

    {
        nome: "Latin American Journal of Aquatic Research",
        categoria: "Oceanografia Geral",
        descricao: "Pesquisa latino-americana sobre Ciências Aquáticas, Oceanografia e recursos marinhos.",
        acesso: "Acesso aberto",
        link: "https://www.lajar.cl/"
    },

    {
        nome: "Revista de Biología Marina y Oceanografía",
        categoria: "Biologia Marinha",
        descricao: "Pesquisa latino-americana sobre biologia marinha e Oceanografia.",
        acesso: "Acesso aberto",
        link: "https://revistas.uv.cl/index.php/rbmo"
    },

    {
        nome: "Ciencias Marinas",
        categoria: "Oceanografia Geral",
        descricao: "Pesquisa científica sobre Oceanografia e ambientes costeiros e marinhos.",
        acesso: "Acesso aberto",
        link: "https://cienciasmarinas.com.mx/"
    },

    {
        nome: "Ocean and Polar Research",
        categoria: "Oceanografia Geral",
        descricao: "Pesquisa sobre Oceanografia, ambientes polares e Ciências do Mar.",
        acesso: "Acesso aberto",
        link: "https://koreascience.kr/journal/HOGBB1.page"
    },

    {
        nome: "Polar Biology",
        categoria: "Biologia Marinha",
        descricao: "Pesquisa sobre organismos e ecossistemas das regiões polares.",
        acesso: "Consultar condições de acesso",
        link: "https://link.springer.com/journal/300"
    },

    {
        nome: "Polar Research",
        categoria: "Oceanografia Geral",
        descricao: "Pesquisa interdisciplinar sobre regiões Ártica e Antártica.",
        acesso: "Acesso aberto",
        link: "https://polarresearch.net/"
    },

    {
        nome: "Antarctic Science",
        categoria: "Oceanografia Geral",
        descricao: "Pesquisa científica multidisciplinar sobre a Antártica e o Oceano Austral.",
        acesso: "Consultar condições de acesso",
        link: "https://www.cambridge.org/core/journals/antarctic-science"
    }

];
