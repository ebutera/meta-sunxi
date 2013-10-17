#force building gl (sunxi-mali) before evas otherwise evas will not build gles support
DEPENDS_mele += "virtual/egl"
DEPENDS_cubieboard += "virtual/egl"
